/**
 * *   Description:
 * *   @File     :ALogAspect.py
 * *   @Author   :王炜 IAmTrying
 * *   @QQ       :690622472
 * *   @Time     :5/17/2021 13:12
 * *   =================================================
 * *             ┌─┐       ┌─┐ + +
 * *          ┌──┘ ┴───────┘ ┴──┐++
 * *          │                 │
 * *          │       ───       │++ + + +
 * *          ███████───███████ │+
 * *          │                 │+
 * *          │       ─┴─       │
 * *          │                 │
 * *          └───┐         ┌───┘
 * *              │         │
 * *              │         │   + +
 * *              │         │
 * *              │         └──────────────┐
 * *              │                        │
 * *              │                        ├─┐
 * *              │                        ┌─┘
 * *              │                        │
 * *              └─┐  ┐  ┌───────┬──┐  ┌──┘  + + + +
 * *                │ ─┤ ─┤       │ ─┤ ─┤
 * *                └──┴──┘       └──┴──┘  + + + +
 * *                       神兽保佑
 * *                      代码无BUG!
 * *   ==================================================
 **/

package cdu.tuogen.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 日记基类
 */
@Aspect
public abstract class ALogAspect {
    //方法列表
    protected Map<String, Method> map;
    //构造函数
    public ALogAspect() { map = Arrays.stream(this.getClass().getDeclaredMethods()).collect(Collectors.toMap(Method::getName, (item) -> item)); }

    /**
     * @return 被代理的类
     */
    abstract Class getProxyClass();

    /**
     * @return 输出的文件路径
     */
    String outLogPath(){return "/log/log.txt";};

    /**
     * 切面方法
     */
    @AfterReturning(value = "execution(* cdu.tuogen.controller.*.*(..))", returning = "returning")
    public void log(JoinPoint joinPoint, Object returning) {
        if (getProxyClass() == null) return;
        String name = joinPoint.getTarget().getClass().getName();
        //如果是代理对象
        if (name.equals(getProxyClass().getName())) {
            //获取方法名
            String mName = joinPoint.getSignature().getName();
            Method method = map.get(mName);
            if (method == null) return;
            try {
                //获取request
                RequestAttributes ra = RequestContextHolder.getRequestAttributes();
                ServletRequestAttributes sra = (ServletRequestAttributes) ra;
                //获取requset、session
                HttpServletRequest request = null;
                HttpSession session = null;
                if (sra != null) {
                    request = sra.getRequest();
                    session = request.getSession();
                }
                //获取model
                Model model = getObjForType(joinPoint.getArgs(), Model.class);
                //获取日志
                String log = (String) method.invoke(this, new Msg(request, session, model, returning,joinPoint.getArgs()));
                if (log==null||log.equals(""))return;
                //输出日志
                out(log);
                System.out.println(log);
            }catch (ClassCastException e){
                logger.error("类型转换异常：代理方法返回值必须为String");
                System.out.println("类型转换异常：代理方法返回值必须为String");
            }catch (IllegalArgumentException e ){
                logger.error("参数不匹配：代理方法的参数只能为Msg");
                System.out.println("参数不匹配：代理方法的参数只能为Msg");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return 根据类型获取改类型的对象，只返回第一个找到的
     */
    private <T> T getObjForType(Object[] args, Class<T> _class) {
        try {
            Optional<Object> first = Arrays.stream(args).filter((item) -> _class.isInstance(item)).findFirst();
            return (T) first.get();
        } catch (Exception e){ return null;}

    }


    //时间格式化
    static private DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ServletContext servletContext;

    /**
     *打印日志
     */
    private void out(String log) throws IOException {
        String path = servletContext.getRealPath("/WEB-INF")+ outLogPath();
        String dirPath = path.substring(0,path.lastIndexOf("/"));
        File file = new File(path);
        File dirFile = new File(dirPath);
        try {
            if (!dirFile.exists()) { dirFile.mkdirs(); }
            if (!file.exists()) { file.createNewFile(); }
            String time = "["+df.format(LocalDateTime.now())+"] ";
            BufferedWriter bf = new BufferedWriter(new FileWriter(path,true));
            bf.append(time+log+"\n");
            bf.flush();
            bf.close();
        } catch (IOException e) {
            System.out.println("日志写入异常，检查路径");
        }

    }

    /**
     * 消息类
     */
    class Msg {
        public HttpServletRequest request;
        public HttpSession session;
        public Model model;
        public Object returning;
        public Object[] args;

        public Msg(HttpServletRequest request, HttpSession session, Model model, Object returning,Object[] args) {
            this.request = request;
            this.session = session;
            this.model = model;
            this.returning = returning;
            this.args=args;
        }
        @Override
        public String toString() {
            return "Msg{" +
                    "request=" + request +
                    ", session=" + session +
                    ", model=" + model +
                    ", returning=" + returning +
                    '}';
        }
    }
}
