package com.cys.animalhospital;

public class AnimalItem {
    String BIZPLC_NM;
    String REFINE_ROADNM_ADDR;
    String REFINE_LOTNO_ADDR;
    String BSN_STATE_NM;
    String LOCPLC_FACLT_TELNO;

    String REFINE_ZIP_CD;

    int app_logo= R.drawable.animal_haspital;
    int iv_Call=R.drawable.baseline_call_24;

    public AnimalItem(String BIZPLC_NM, String REFINE_ROADNM_ADDR, String REFINE_LOTNO_ADDR,String REFINE_ZIP_CD, String BSN_STATE_NM, String LOCPLC_FACLT_TELNO, int app_logo, int iv_Call) {
        this.BIZPLC_NM = BIZPLC_NM;

        this.REFINE_ROADNM_ADDR = REFINE_ROADNM_ADDR;
        this.REFINE_LOTNO_ADDR = REFINE_LOTNO_ADDR;

        this.BSN_STATE_NM = BSN_STATE_NM;

        this.LOCPLC_FACLT_TELNO = LOCPLC_FACLT_TELNO;

        this.app_logo = app_logo;
        this.iv_Call = iv_Call;

        this.REFINE_ZIP_CD=REFINE_ZIP_CD;
    }


    public AnimalItem() {

    }
}
