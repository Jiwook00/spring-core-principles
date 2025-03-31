package hello.core.singleton;

public class SingletonService {

    // 클래스 레벨에 올라가기 때문에 딱 하나만 존재하게 된다.
    // 이 instance의 참조를 꺼낼 수 있는 방법은 SingletonService밖에 없다.
    // 이 객체의 인스턴스가 필요하면 오직 getInstance() 메서드를 통해서만 조회할 수 있다. 이 메서드를 호출하면 항상 같은 인스턴스를 반환
    private static final SingletonService instance = new SingletonService();


    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
