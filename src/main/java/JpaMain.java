import entity.Items.Movie;
import entity.Member;
import entity.Team;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //비영속
//            entity.Member member = new entity.Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            //영속
//            System.out.println("==Before==");
//            em.persist(member);
//            System.out.println("==After==");

            //insert
//            em.persist(member);

            //select
//            entity.Member findMember = em.find(entity.Member.class, 1L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getId() = " + findMember.getName());

//            List<entity.Member> result = em.createQuery("select m from entity.Member as m", entity.Member.class)
//                    .setFirstResult(1)  //FirstrResult 부터 MaxResult까지 가져와라
//                    .setMaxResults(10)
//                    .getResultList();
//
//            for (entity.Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

            //update
//            findMember.setName("HelloJPA"); //set 해준 뒤 findMember를 저장하지않아도 된다 (JPA가 관리중 변경사항이 있는지 트렌젝션 커밋시점에 체크를 함 (변경감지) 변경감지 -> update쿼리 )

            //delete
//            em.remove(findMember);



            //회원 엔티티를 영속성 컨텍스트에서 분리, 준영속상태
//            em.detach(member);

            //객체를 삭제한 상태(삭제)
//            em.remove(member);

//            entity.Member findMember = em.find(entity.Member.class, 101L);
//            entity.Member findMember2 = em.find(entity.Member.class, 101L); //똑같은걸 두번째 찾을 때는 select쿼리문이 한번 나간다 (첫번째 찾을때는 1차캐시에서 2번째부터는 데이터베이스에서 조회한다) 가져와서 1차캐시에 저장해놓는다(영속성컨텍스트에 올림) -> 그리고 1차캐시에서 가져온다
//            //insert쿼리문이 나가기 전에 조회됨 1차캐시에서 조회하기 때문에
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());
//
//            System.out.println("findMember == findMember2 = " + (findMember == findMember2)); //동일성비교 true

//            entity.Member member1 = new entity.Member(150L, "A");
//            entity.Member member2 = new entity.Member(160L, "B");
//            em.persist(member1);
//            em.persist(member2); //여기까진 insert 쿼리문을 보내지 않음
//            //쓰기지연 SQL저장소에 쿼리문들을 저장해 놓았다가 커밋시점에 쿼리문을 한번에 보낸다

//            entity.Member member = em.find(entity.Member.class, 150L);
//            member.setName("BTH");  //변경감지 -> 트랜잭션 커밋시점에 변경사항 반영

//            entity.Member member = new entity.Member(200L, "member200");
//            em.persist(member);
//
//            em.flush(); //이 시점에 insert 쿼리문이 나가게된다
//            //플러쉬는 쓰기지연SQL저장소에 쌓인 쿼리들을 데이터베이스에 반영하는 과정이다 (변경감지등 포함) 보통 커밋이나 쿼리(JPQL)를 실행하는시점에 자동으로 호출됨(기본값) (이것도 설정으로 변경가능하다)

//            entity.Member member = em.find(entity.Member.class, 150L);
//            member.setName("AAA");

//            em.detach(member); //JPA에서 관리를 안하게됨(준영속상태) <- 커밋시점에 아무일도 일어나지 않을 것
//
//            em.clear(); //영속성 컨텍스트를 통으로 다 지움(초기화)
//
//            entity.Member member2 = em.find(entity.Member.class, 150L); //영속성 컨텍스트를 초기화했기때문에 DB에서 조회해와서 1차캐시에 다시 올려놓기위해 select쿼리문이 나간다

//            em.close(); //영속성 컨텍스트 종료

            //저장
//            Team team = new Team();
//            team.setName("TeamA");
////            team.getMembers().add(member); //members는 읽기전용!!!!!!!!!!!!! 가짜매핑!!!!!!!!!!
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.changeTeam(team); //**  연관관계 편의 메소드 사용 changeTeam()  //JPA에서 insert할 때 자동으로 FK값을 사용함  <- 이렇게 해야 함 (연관관계 주인에 값을 넣어줌)
//            em.persist(member);

//            team.getMembers().add(member); //** 연관관계 편의 메소드 사용으로 코드가 필요없어짐

//            em.flush();
//            em.clear();

//            Member findMember = em.find(Member.class, member.getId());
//
////            Team findTeam = findMember.getTeam();
//
//            List<Member> members = findMember.getTeam().getMembers(); //Member -> Team -> Member 양쪽으로 왔다 갔다 하고 있다 (양방향 연관관계)
//
//            for (Member m : members) {
//                System.out.println("m.getUsername() = " + m.getUsername());
//            }

//            Team findTeam = em.find(Team.class, team.getId()); //플러시, 클리어가 없다면 1차캐시에서 가지고 옴  team.getMembers().add(member);가 없다면 아무것도 가져오지 못한다
//            List<Member> members = findTeam.getMembers();
//            for (Member m : members) {
//                System.out.println("m.getUsername() = " + m.getUsername()); //알맞은 값을 가져와서 출력이되긴 한다 하지만 객체지향스럽지 않다
//                //그리고 두군데서 문제가 된다
//                //플러시, 클리어를 해버리면 문제가 없다 그런데 없다면.. 1차캐시에서 가지고 오겠죠? -> team.getMembers().add(member);가 없다면 아무것도 가져오지 못한다
//                //테스트 케이스 작성할때 문제가 됨
//            }

//            Member member = new Member();
//            member.setUsername("member1");
//
//            em.persist(member);
//
//            Team team = new Team();
//            team.setName("TeamA");
//            //
//            team.getMembers().add(member); //Member테이블에 있는 외래키가 업데이트 될 것.
//
//            em.persist(team);

//            Movie movie = new Movie();
//            movie.setDirector("aaa");
//            movie.setActor("bbb");
//            movie.setName("바람과함께 사라지다");
//            movie.setPrice(10000);

//            Member member = new Member();
//            member.setUsername("user1");
//            member.setCreateBy("kim");
//            member.setCreateDate(LocalDateTime.now());
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

//            Member member = em.find(Member.class, 1L);
//            printMember(member);
//
//            printMemberAndTeam(member);

            Member member = new Member();
            member.setUsername("hello");

            em.persist(member);

            em.flush();
            em.clear();

//            Member findMember = em.find(Member.class, member.getId());
//            Member findMember = em.getReference(Member.class, member.getId()); //조회할 때는 쿼리가 나가지않고 (프록시객체 조회)
//            System.out.println("findMember.getId() = " + findMember.getId()); //윗줄 코드에서 파라미터에서 사용됬기때문에 DB에서 찾아오지않아도 알 수 있기때문에 쿼리문이 나가지 않음
//            System.out.println("findMember.getClass() = " + findMember.getClass()); //프록시(가짜) 클래스
//            System.out.println("findMember.getUsername() = " + findMember.getUsername()); //값이 사용되는 시점에 쿼리가 나가게 됨 (실제 가져다 쓰는 시점)
//            System.out.println("findMember.getUsername() = " + findMember.getUsername()); //값이 있으니까 쿼리가 한번 더 나가지 않고 조회가 된다

            Member m1 = em.find(Member.class, member.getId());
            System.out.println("m1.getClass() = " + m1.getClass());

            Member reference = em.getReference(Member.class, member.getId());
            System.out.println("reference = " + reference.getClass()); //Proxy //이미 영속성 컨텍스트에 있으면 영속성 컨텍스트(실제엔티티)에서 가져오기때문에 클래스는 Member로 찍힌다

            System.out.println("reference == m1 = " + (reference == m1)); //true //프록시에서 가져온다면 타입이 안맞기 때문에 false가 떠야하는데 Member에서 가져왔기때문에 == 비교가 가능한것! 그리고 JPA는 기본적으로 ==비교가 되도록 맞춘다

            Hibernate.initialize(reference); //프록시 강제 초기화

            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(reference)); //프록시 인스턴스의 초기화 여부 확인

            tx.commit(); //트랜젝션 커밋시점에 쿼리가 나가게 된다
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void printMember(Member member) {
        System.out.println("member.getUsername() = " + member.getUsername());
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        Team team = member.getTeam();
        System.out.println("team = " + team);
    }
}

