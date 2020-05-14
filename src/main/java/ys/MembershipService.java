package ys;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="MembershipService_table")
public class MembershipService {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long clientId;
    private Long membershipId;

    @PrePersist
    public void onPrePersist(){
        DeletedMembership deletedMembership = new DeletedMembership();
        BeanUtils.copyProperties(this, deletedMembership);
        deletedMembership.publishAfterCommit();


        RegisterdMembership registerdMembership = new RegisterdMembership();
        BeanUtils.copyProperties(this, registerdMembership);
        registerdMembership.publishAfterCommit();


        CheckedMembership checkedMembership = new CheckedMembership();
        BeanUtils.copyProperties(this, checkedMembership);
        checkedMembership.publishAfterCommit();


    }


    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    public Long getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Long membershipId) {
        this.membershipId = membershipId;
    }




}
