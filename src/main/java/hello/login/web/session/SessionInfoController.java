package hello.login.web.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class SessionInfoController {

    @GetMapping("/session-info")
    public String sessionInfo(HttpServletRequest request){
        HttpSession session = request.getSession(false);

        if(session == null){
            return "세션 없음";
        }

        session.getAttributeNames().asIterator()
                .forEachRemaining(name -> log.info("name={}, value={}", name, session.getAttribute(name)));

        log.info("sessionId={}", session.getId());
        log.info("maxInactiveInterval={}", session.getMaxInactiveInterval());
        log.info("creationTime={}", session.getCreationTime());
        log.info("lastAccessedTime={}", session.getLastAccessedTime());
        log.info("isNew={}", session.isNew());

        return "세션 정보 출력";
    }

}
