package com.tt.recyclenow.bean;

/**
 * Created by tu on 2018/7/22.
 */

public class WebAuthBean extends BaseRep {

    /**
     * data : {"url":"https://api.fudata.cn/mobile/access/h5/organization?p=8F11012D88E68B3EEBC503A080F09E8CB2DE9C0AC82430D9569A0A41EAD521B6950C353EE00A3423C617715BC9ED3DF5EBB7F2AE0A5D182FD53475EA3023277129DF3A9A3AEE7125844FE3D0142404041A59D7245D792A49EAFA42AD3104C862ED3459049E2D0C5E6FB3E7C2BFE18ACF&user_token=425ccf323b06c59e652763af94f06ba679d2b873c820788362c7d9c97ff28e58&open_id=nvxxtz2a2mk5axpaiieoxamvxfyb6yn0fvuuubcn&organizationType=TELECOM&inputphone=13018924230&canedit=0"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * url : https://api.fudata.cn/mobile/access/h5/organization?p=8F11012D88E68B3EEBC503A080F09E8CB2DE9C0AC82430D9569A0A41EAD521B6950C353EE00A3423C617715BC9ED3DF5EBB7F2AE0A5D182FD53475EA3023277129DF3A9A3AEE7125844FE3D0142404041A59D7245D792A49EAFA42AD3104C862ED3459049E2D0C5E6FB3E7C2BFE18ACF&user_token=425ccf323b06c59e652763af94f06ba679d2b873c820788362c7d9c97ff28e58&open_id=nvxxtz2a2mk5axpaiieoxamvxfyb6yn0fvuuubcn&organizationType=TELECOM&inputphone=13018924230&canedit=0
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
