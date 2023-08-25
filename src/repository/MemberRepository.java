package repository;

import dto.MemberDTO;



import java.util.ArrayList;
import java.util.List;


public class MemberRepository {
    List<MemberDTO> memberDTOList = new ArrayList<>();

    public boolean insert(MemberDTO memberDTO) {
        return memberDTOList.add(memberDTO);
    }

    public MemberDTO login(String email, String password) {
        for (MemberDTO memberDTO : memberDTOList) {
            if (email.equals(memberDTO.getMemberEmail()) && password.equals(memberDTO.getMemberPassword())) {
                return memberDTO;
            }
        }
        return null;
    }

    public List<MemberDTO> findAll() {
        return memberDTOList;
    }

    public MemberDTO update(String email, String password) {
        for (MemberDTO memberDTO : memberDTOList) {
            if (email.equals(memberDTO.getMemberEmail()) && password.equals(memberDTO.getMemberPassword())) {
                return memberDTO;
            }
        }
        return null;
    }

    public MemberDTO delete(String email, String password) {
        for (MemberDTO memberDTO : memberDTOList) {
            if (email.equals(memberDTO.getMemberEmail()) && password.equals(memberDTO.getMemberPassword())) {
                memberDTOList.remove(memberDTO);
                if (!memberDTOList.isEmpty()) {
                    System.out.println(memberDTOList);
                    return memberDTO;
                } else {
                    return memberDTO;
                }
            }
        }
        return null;
    }


    public boolean cheack(String memberEmail) {
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberEmail.equals(memberDTO.getMemberEmail())) {
                //일치하니까 사용불가능한 이메일
                return false;
            }
        }
        return true;
    }
}