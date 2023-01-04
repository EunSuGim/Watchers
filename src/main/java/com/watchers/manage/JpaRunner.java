//package com.watchers.manage;
//
//import com.watchers.manage.domain.Caution.Caution;
//import com.watchers.manage.domain.Etc.Etc;
//import com.watchers.manage.domain.Member.Member;
//import org.hibernate.Session;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//import java.util.Date;
//
//@Component
//@Transactional
//public class JpaRunner implements ApplicationRunner {
//
//    @PersistenceContext
//    EntityManager entityManager;
//
//    public void run(ApplicationArguments args) throws Exception{
//
//        Member member = new Member();
//        member.setName("정자셉니다");
//        member.setAge(30);
//        member.setGender("M");
//        member.setTier("D");
//        member.setEnrolledDate(new Date());
//
//        Etc etc = new Etc();
//        etc.setIssue("다음주까지 게임못함");
//        member.addEtc(etc);
//
//        Caution caution = new Caution();
//        caution.setCautionCount(0);
//        member.addCaution(caution);
//
//        Session session = entityManager.unwrap(Session.class);
//        session.save(member);
//
//    }
//}
