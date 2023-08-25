package main;

import service.MemberService;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberService memberService = new MemberService();
        boolean run = true;
        while (run) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("1.회원가입 2. 로그인 3. 회원목록조회 4.회원정보수정 5.회원삭제 6. 로그아웃 0.종료");
            System.out.println("----------------------------------------------------------------");
            System.out.println("메뉴선택> ");
            int sel = scanner.nextInt();

            if (sel == 1) {
                System.out.println("회원가입");
                memberService.insert();
            } else if (sel == 2) {
                System.out.println("로그인");
                memberService.login();
            } else if (sel == 3) {
                System.out.println("회원목록조회");
                memberService.findAll();
            } else if (sel == 4) {
                System.out.println("회원정보수정");
                memberService.update();
            } else if (sel == 5) {
                System.out.println("회원탈퇴");
                memberService.delete();
            } else if (sel == 6) {
                System.out.println("로그아웃");
                memberService.logout();
            } else {
                System.out.println("시스템종료");
                run = false;

            }
        }
    }
}