package youtube;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;


@Entity
@Table(name="MembershipService_table")
public class MembershipService {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long clientId;
    private Long membershipId;

    @PrePersist
    public void onPrePersist(){

        RegisterdMembership registerdMembership = new RegisterdMembership();
        BeanUtils.copyProperties(this, registerdMembership);
        registerdMembership.publishAfterCommit();
        System.out.println(("**********멤버십 생성되었습니다.**********"));





    }

    @PostPersist
    public void onPostUploaded(){
        CheckedMembership checkedMembership = new CheckedMembership();
        BeanUtils.copyProperties(this, checkedMembership);
        checkedMembership.publishAfterCommit();
        System.out.println(("**********멤버십 체크.**********"));
    }

    @PreRemove
    public void onPreRemove(){

        DeletedMembership deletedMembership = new DeletedMembership();
        BeanUtils.copyProperties(this, deletedMembership);
        deletedMembership.publishAfterCommit();

        System.out.println(("**********Membership deleted!**********"));
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
