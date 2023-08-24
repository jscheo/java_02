package repository;

import dto.MemberDTO;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberRepository {
    List<MemberDTO> memberDTOList = new ArrayList<>();
    private static String loginEmail= null;
    public boolean insert(MemberDTO memberDTO) {
        return memberDTOList.add(memberDTO);
    }

    public void login(String email, String password) {
        for(MemberDTO memberDTO: memberDTOList){
            if(email.equals(memberDTO.getMemberEmail()) && password.equals(memberDTO.getMemberPassword())){
                System.out.println("로그인 성공");
                loginEmail = email;
            }else{
                System.out.println("로그인 실패");
            }
        }
    }

    public List<MemberDTO> findAll() {
        return memberDTOList;
    }

    public void update(String email, String password) {
        Scanner scanner = new Scanner(System.in);
        for(MemberDTO memberDTO: memberDTOList){
            if(email.equals(memberDTO.getMemberEmail()) && password.equals(memberDTO.getMemberPassword())){
                System.out.println("수정할 전화번호를 입력하세요>");
                String mobile = scanner.next();
                memberDTO.setMemberMobile(mobile);
                System.out.println("수정완료");
                System.out.println(memberDTO);
            }else{
                System.out.println("수정실패");
            }
        }
    }

    public void delete(long id) {
        Scanner scanner = new Scanner(System.in);
        if(loginEmail== null){
            System.out.println("로그인을 하세요");
        }else{
            for(MemberDTO memberDTO : memberDTOList){
                if(id == memberDTO.getId()){
                    System.out.println("비밀번호를 입력하세요");
                    String password = scanner.next();
                    if(password.equals(memberDTO.getMemberPassword())){
                        memberDTOList.remove(memberDTO);
                        System.out.println("삭제 완료");
                        System.out.println(memberDTOList);
                    }
                }else{
                    System.out.println("없는 회원 입니다.");
                }
            }
        }

    }

    public void logout() {
        System.out.println("로그아웃되었습니다.");
        loginEmail=null;
    }

    public boolean cheack(String memberEmail) {
        for(MemberDTO memberDTO: memberDTOList){
            if(memberEmail.equals(memberDTO.getMemberEmail())){
                return false;
            }
        }
        return true;
    }
}