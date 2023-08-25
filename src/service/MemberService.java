package service;

import dto.MemberDTO;
import repository.MemberRepository;


import java.util.List;
import java.util.Scanner;

public class MemberService {
    Scanner scanner = new Scanner(System.in);
    MemberRepository memberRepository = new MemberRepository();
    private static String loginEmail = null;

    //    private static String loginEmail = null;
    public void insert() {
        boolean run = true;
        while (run) {
            System.out.print("이메일 입력> ");
            String memberEmail = scanner.next();
            boolean result1 = memberRepository.cheack(memberEmail);
            if (result1) {
                System.out.println("사용가능한 이메일입니다.");
                System.out.print("비밀번호 입력 >");
                String memberPassword = scanner.next();
                System.out.print("이름입력> ");
                String memberName = scanner.next();
                System.out.print("전화번호 입력> ");
                String memberMobile = scanner.next();

                MemberDTO memberDTO = new MemberDTO(memberEmail, memberPassword, memberName, memberMobile);

                boolean result = memberRepository.insert(memberDTO);

                if (result) {
                    System.out.println("회원가입완료");
                    System.out.println(memberDTO);
                    run = false;
                } else {
                    System.out.println("등록실패");
                }
            } else {
                System.out.println("중복된 아이디입니다.");
            }
        }


    }

    public void login() {
        System.out.print("이메일 입력>");
        String email = scanner.next();
        System.out.print("비밀번호입력>");
        String password = scanner.next();
        MemberDTO memberDTO = memberRepository.login(email, password);
        if (memberDTO != null) {
            System.out.println("로그인 성공");
            loginEmail = email;
        } else {
            System.out.println("로그인 실패");
        }

    }

    public void findAll() {
        List<MemberDTO> memberDTOList = memberRepository.findAll();
        for (MemberDTO memberDTO : memberDTOList) {
            System.out.println(memberDTO);
        }
    }

    public void update() {
        if(loginEmail ==null){
            System.out.println("로그인 먼저 하세요");
            login();
        }else{
            System.out.println("이메일 다시 입력>");
            String email = scanner.next();
            System.out.println("비밀번호 다시 입력> ");
            String password = scanner.next();
            MemberDTO memberDTO = memberRepository.update(email, password);
            if(memberDTO != null){
                System.out.println("수정하고싶은 전화번호 입력>");
                String mobile = scanner.next();
                memberDTO.setMemberMobile(mobile);
                System.out.println("수정완료");
                System.out.println(memberDTO);
            }else{
                System.out.println("이메일 또는 비밀번호가 틀립니다.");
            }
        }

    }

    public void delete() {
        if (loginEmail == null) {
            System.out.println("로그인을 하세요");
            login();
        } else {
            System.out.println("이메일을 다시 입력하세요");
            String email = scanner.next();
            System.out.println("비밀번호를 다시 입력하세요");
            String password = scanner.next();
            MemberDTO memberDTO = memberRepository.delete(email, password);
            if (memberDTO != null) {
                System.out.println("삭제성공");
                loginEmail = null;
            }
        }

    }

    public void logout() {
        if (loginEmail != null) {
            loginEmail = null;
            System.out.println("로그아웃되었습니다.");
        } else {
            System.out.println("로그인 하세요");
            System.out.println("이메일 입력");
            String email = scanner.next();
            System.out.println("비밀번호 입력");
            String password = scanner.next();
            MemberDTO memberDTO = memberRepository.login(email, password);
            if (memberDTO != null) {
                System.out.println("로그인 성공");
                loginEmail = memberDTO.getMemberEmail();
            } else {
                System.out.println("로그인 실패");
            }
        }
    }
}