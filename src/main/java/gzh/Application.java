package gzh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class Application {
//  @Autowired
//  private RedisTemplate<String, User> redisTemplate;

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @RequestMapping("/")
  @ResponseBody
  public String index() {
    System.out.println("start");

    // 保存字符串
    stringRedisTemplate.opsForValue().set("aaa", "111");

    return "Hello World!";
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}