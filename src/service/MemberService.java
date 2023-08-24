package service;

import dto.MemberDTO;
import repository.MemberRepository;

import java.util.List;
import java.util.Scanner;

public class MemberService {
    Scanner scanner = new Scanner(System.in);
    MemberRepository memberRepository = new MemberRepository();
    public void insert() {
        System.out.print("이메일 입력> ");
        String memberEmail = scanner.next();
        System.out.print("비밀번호 입력 >");
        String memberPassword = scanner.next();
        System.out.print("이름입력> ");
        String memberName = scanner.next();
        System.out.print("전화번호 입력> ");
        String memberMobile = scanner.next();

        MemberDTO memberDTO = new MemberDTO(memberEmail, memberPassword, memberName, memberMobile);

        boolean result = memberRepository.insert(memberDTO);

        if(result){
            System.out.println("회원가입완료");
            System.out.println(memberDTO);
        }else{
            System.out.println("등록실패");
        }

    }

    public void login() {
        System.out.print("이메일 입력>");
        String email = scanner.next();
        System.out.print("비밀번호입력>");
        String password = scanner.next();
        memberRepository.login(email, password);

    }

    public void findAll() {
        List<MemberDTO> memberDTOList = memberRepository.findAll();
        for(MemberDTO memberDTO: memberDTOList){
            System.out.println(memberDTO);
        }
    }

    public void update() {
        System.out.println("이메일 입력>");
        String email = scanner.next();
        System.out.println("비밀번호 입력> ");
        String password = scanner.next();
        memberRepository.update(email, password);
    }

    public void delete() {
        System.out.println("삭제할 id> ");
        long id = scanner.nextLong();
        memberRepository.delete(id);
    }
}
