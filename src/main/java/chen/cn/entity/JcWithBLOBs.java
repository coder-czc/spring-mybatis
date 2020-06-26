package chen.cn.entity;

public class JcWithBLOBs extends Jc {
    private String kOverview;

    private String departOpinion;

    private String companyOption;

    public String getkOverview() {
        return kOverview;
    }

    public void setkOverview(String kOverview) {
        this.kOverview = kOverview == null ? null : kOverview.trim();
    }

    public String getDepartOpinion() {
        return departOpinion;
    }

    public void setDepartOpinion(String departOpinion) {
        this.departOpinion = departOpinion == null ? null : departOpinion.trim();
    }

    public String getCompanyOption() {
        return companyOption;
    }

    public void setCompanyOption(String companyOption) {
        this.companyOption = companyOption == null ? null : companyOption.trim();
    }
}