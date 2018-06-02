package com.hzecool.app.data;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务器接口定义  对应服务器interfaceId
 *
 * @author tutu
 * @date 2017/4/22
 */

public class ServiceInterface {

    /**
     * 新平台的请求路径头部
     */
    public static final String REQUEST_PATH_NEWFRM = "newfrm/callInterface.do";

    public static final String REQUEST_SLH2_PATH = "api.do";


    /**
     * 原手机平台的请求路径头部
     */
    public static final String REQUEST_PATH = "callInterface.do";

    /**
     * 文件上传路劲头部
     */
    public static final String UPFILE_PATH = "uploadMultiFile.do";

    /**
     * 开单初始化 接口id
     */
    public static final String INTERFACEID_QF_20001_1 = "qf-20001-1";

    /**
     * 开单初始化(订货单) 接口id
     */
    public static final String INTERFACEID_QF_20011_1 = "qf-20011-1";

    /**
     * 特殊货品 接口id
     */
    public static final String INTERFACEID_CS_20001_5 = "cs-20001-5";

    /**
     * 订货保存 接口id
     */
    public static final String INTERFACEID_SF_20011_1 = "sf-20011-1";

    /**
     * 开单保存 接口id
     */
    public static final String INTERFACEID_SF_20001_1 = "sf-20001-1";

    /**
     * 获取客户积分余额 接口id
     */
    public static final String INTERFACEID_CS_20001_2 = "cs-20001-2";

    /**
     * 同步基础数据 接口id
     */
    public static final String INTERFACEID_CS_SYNCDATA = "cs-syncdata";

    /**
     * 爆款接口id
     */
    public static final String INTERFACEID_QL_25116 = "ql-25116";

    /**
     * 系统参数获取id
     */
    public static final String INTERFACEID_QL_1160 = "ql-1160";
    /**
     * 角色系统参数
     */
    public static final String INTERFACEID_ROLE_PARAM = "cs-getroleparam";
    /**
     * 角色系统参数批量
     */
    public static final String INTERFACEID_ROLE_PARAM_BATCH = "cs-getroleparam-batch";
    /**
     * 获取库存 id
     */
    public static final String INTERFACEID_CS_GET_GOODS_STOCK_BY_IDS = "cs-getGoodsStockByIds";

    /**
     * 门店调入
     */
    public static final String INTERFACEID_QL_22033 = "ql-22033";

    /**
     * 门店待调入
     */
    public static final String INTERFACEID_QL_22032 = "ql-22032";

    /**
     * 门店调出
     */
    public static final String INTERFACEID_QL_22031 = "ql-22031";

    /**
     * 门店调出开单初始化
     */
    public static final String INTERFACEID_QF_22031_1 = "qf-22031-1";

    /**
     * 字典查询接口
     */
    public static final String INTERFACEID_QD_DICT = "qd-dict";

    /**
     * 我的-客户
     */
    public static final String INTERFACEID_QL_25115 = "ql-25115";

    /**
     * 爆款-未拿货
     */
    public static final String INTERFACEID_QL_25117 = "ql-25117";
    /**
     * 业绩
     */
    public static final String INTERFACEID_QL_25114 = "ql-25114";

    /**
     * 核销列表查询
     */
    public static final String INTERFACEID_QL_20023 = "ql-20023";

    /**
     * 调出单保存
     */
    public static final String INTERFACEID_SF_22031_1 = "sf-22031-1";

    /**
     * 获取标签
     */
    public static final String INTERFACEID_QL_25113 = "ql-25113";

    /**
     * 保存标签
     */
    public static final String INTERFACEID_SF_25113 = "sf-25113";
    /**
     * 查询分享信息
     */
    @Deprecated
    public static final String INTERFACEID_CS_SHARE = "cs-shareSaleBill";

    public static final String INTERFACEID_CS_SHARE_ORDER = "cs-share";


    /**
     * 解除绑定
     */
    public static final String INTERFACEID_QL_unbinding = "cs-unbundlingForAssistant";
    /**
     * 盘点单初始化
     */
    public static final String INTERFACEID_QF_22021_1 = "qf-22021-1";

    /**
     * 盘点单保存
     */
    public static final String INTERFACEID_SF_22021_1 = "sf-22021-1";

    /**
     * 设置销售单的发货状态
     */
    public static final String INTERFACEID_CS_DELIVER_FLAG = "cs-setSaleBillDeliverFlag";
    /**
     * 结束订货单
     */
    public static final String INTERFACEID_CS_20011_4 = "cs-20011-4";

    /**
     * 作废销售单
     */
    public static final String INTERFACEID_CS_INVALID = "cs-20001-1";

    /**
     * 作废订货单
     */
    public static final String INTERFACEID_CS_INVALID_BOOKING = "cs-20011-1";


    /**
     * 门店调入作废
     */
    public static final String INTERFACEID_CS_TRANS_IN_INVALID = "cs-1863";

    /**
     * 挂单销售单作废
     */
    public static final String INTERFACEID_CS_PENDING_INVALID = "cs-14222-2";

    /**
     * 挂单订货单作废
     */
    public static final String INTERFACEID_CS_SALEORDER_CANCEL = "cs-saleorder-cancel";

    /**
     * 作废盘点单
     */
    public static final String INTERFACEID_CS_INVALID_INVEN = "cs-24021-1";

    /**
     * 作废调出单
     */
    public static final String INTERFACEID_CS_INVALID_OUT = "cs-22031-1";

    /**
     * 请求树形数据
     */
    public static final String INTERFACEID_QD_TREE = "qd-tree";

    /**
     * 保存客户
     */
    public static final String INTERFACEID_SF_ADD_CUSTOER = "sf-24002-1";

    /**
     * 意见反馈
     */
    public static final String INTERFACEID_SF_FORUMLOG = "sf-forumLog";


    /**
     * 设置标签
     */
    public static final String INTERFACEID_CS_SET_TAG = "cs-setSaleBillTag";

    /**
     * 盘点单详情
     */
    public static final String INTERFACEID_QF_INVEN_D = "qf-22021-1";

    /**
     * 调出详情
     */
    public static final String INTERFACEID_QF_TRAN_OUT_D = "qf-22031-1";

    /**
     * 打印接口
     */
    //    public static final  String INTERFACEID_CS_PRINT = "cs-22031-3";

    /**
     * 更新打印状态
     */
    public static final String INTERFACEID_CS_UPDATE_PRINT = "cs-updatePrintFlag";


    /**
     * 调入详细
     */
    public static final String INTERFACEID_QF_22032_1 = "qf-22032-1";
    public static final String INTERFACEID_SF_22032_1 = "sf-22032-1";
    public static final String INTERFACEID_QF_22033_1 = "qf-22033-1";

    /**
     * 获取打印数据
     */
    public static final String INTERFACEID_CS_PRINT = "cs-getprintxmlfromserver";

    /**
     * 短信模板
     */
    public static final String NTERFACEID_CS_MESSAGE = "cs-get-sms-template";

    /**
     * 删除标签
     */
    public static final String NTERFACEID_CS_DELTAG = "cs-delTag";

    /**
     * 修改名称
     */
    public static final String INTERFACEID_CS_UPDATESTAFFFORASSISTANT = "cs-updateStaffForAssistant";

    /**
     * 批量获取上次价
     */
    public static final String INTERFACEID_CS_GETLAST_PRICE_BATCH = "cs-getLastPriceBatch";

    /**
     * 发版说明POST
     */
    public static final String INTERFACEID_QL_9910 = "ql-9910";
    /**
     * 门店名称
     */
    public static final String INTERFACEID_QF_1501 = "qf-1501";
    /**
     * 编辑款号
     */
    public static final String INTERFACEID_SF_24001_1 = "sf-24001-1";
    /**
     * 类别
     */
    public static final String INTERFACEID_CS_GETUSEDMATCLASS = "cs-getUsedMatClass";
    /**
     * 指定类别的款号
     */
    public static final String INTERFACEID_QL_25019 = "ql-25019";

    /**
     * 我的客户
     */
    public static final String INTERFACEID_QL_INVENCUSTOMER = "ql-25018";
    /**
     * 货品查询
     */
    public static final String INTERFACEID_QL_24001 = "ql-24001";
    /**
     * 货品详情
     */
    public static final String INTERFACEID_QF_24001_2 = "qf-24001-2";
    /**
     * 物流商信息
     */
    public static final String INTERFACEID_QL_25020 = "ql-25020";

    /**
     * 储值验证码
     */
    public static final String INTERFACEID_CS_SENDCODE = "cs-storedvalue-sendcode";
    public static final String INTERFACEID_CS_CHECKCODE = "cs-storedvalue-checkcode";

    /**
     * 账户列表
     */
    public static final String INTERFACEID_CS_ACCOUNT = "cs-getAccountData";

    /**
     * 小程序二维码
     */
    public static final String INTERFACEID_CS_SHAREAPP = "cs-shareApp";

    /**
     * 获取分享记录
     */
    public static final String INTERFACEID_QL_25118 = "ql-25118";

    /**
     * 分享的次数和分享的款号
     * POST 业务地址/slh/callInterface.do?interfaceid=cs-shareviewinfo
     */
    public static final String INTERFACEID_CS_SHAREVIEWINFO = "cs-shareviewinfo";

    /**
     * 浏览的客户列表
     * POST 业务地址/slh/callInterface.do?interfaceid=cs-shareViewerlist
     */
    public static final String INTERFACEID_CS_SHAREVIEWERLIST = "cs-shareViewerlist";


    /**
     * 退货验证提醒
     */
    public static final String INTERFACEID_TAKEPRODUCT = "get-customer-sku-sum";

    /**
     * 配货单列表查询
     */
    public static final String INTERFACEID_QL_20005 = "ql-20005";

    /**
     * 配货单详情
     */
    public static final String INTERFACEID_QF_20005_1 = "qf-20005-1";

    /**
     * 配货单保存
     */
    public static final String INTERFACEID_SF_20005_1 = "sf-20005-1";

    /**
     * 修改配货单标记
     */
    public static final String INTERFACEID_UPDATE_INVDISFLAG = "ec-trade-salesBill-updateInvDisFlag";

    /**
     * 发货单保存
     */
    public static final String INTERFACEID_SF_20005_2 = "sf-20005-2";

    /**
     * 获取厂商id
     * POST 业务地址/slh/callInterface.do?interfaceid=cs-getDwidByTargetEpid
     */
    public static final String INTERFACEID_CS_GETDWIDBYTARGETEPID = "cs-getDwidByTargetEpid";

    /**
     * 扫码入库
     * POST 业务地址/slh/callInterface.do?interfaceid=cs-importPurBySaleQr
     */
    public static final String INTERFACEID_CS_IMPORTPURBYSALEQR = "cs-importPurBySaleQr";

    /**
     * 设置厂商编码
     * POST 业务地址/slh/callInterface.do?interfaceid=cs-setsuppliercode
     */
    public static final String INTERFACEID_CS_SETSUPPLIERCODE = "cs-setsuppliercode";

    /**
     * 入库单详情
     * POST 业务地址/slh/newfrm/callInterface.do?interfaceid=qf-21001-1
     */
    public static final String INTERFACEID_QF_21001_1 = "qf-21001-1";

    /**
     * 入库单列表
     * POST 业务地址/slh/newfrm/callInterface.do?interfaceid=ql-21001
     */
    public static final String INTERFACEID_QL_21001 = "ql-21001";

    /**
     * 获取敏感字段批量
     * cs-getrolecolumn
     */
    public static final String INTERFACEID_CS_GETROLECOLUMN = "cs-getRolecolumnBatch";

    /**
     * 采购入库单保存
     */
    public static final String INTERFACEID_SAVE_STOCK_IN = "sf-21001-1";

    /**
     * 视频签名
     */
    public static final String INTERFACEID_VEDIO_SIGN = "cs-shortVedioSign";
    /**
     * 打印配置界面选项字典及其关联关系
     */
    public static final String INTERFACEID_PRINT_DICT_PARAMS = "ec-print-printer-getDictRetation";

    /**
     * 打印配置获取接口
     */
    public static final String INTERFACEID_PRINT_PARAMS_QUERY = "ec-print-printer-getByClientDeviceNo";

    /**
     * 打印配置保存接口
     */
    public static final String INTERFACEID_PRINT_PARAMS_SAVE = "ec-print-printer-save";

    /**
     * 打印测试
     */
    public static final String INTERFACEID_PRINT_TEST = "ec-print-printer-printTest";


    /**
     * 销售单挂单列表
     */
    public static final String INTERFACEID_QL_20086 = "ql-20086";
    /**
     * 订货单挂单列表
     */
    public static final String INTERFACEID_QL_20087 = "ql-20087";
    /**
     * 物流信息
     */
    public static final String INTERFACEID_LOGISTICS = "cs-getexpress-information";

    /**
     * 销售单查询
     */
    public static final String INTERFACEID_QL_20001 = "ql-20001";
    /**
     * 订货单查询
     */
    public static final String INTERFACEID_QL_20011 = "ql-20011";
    /**
     * 按订货开单列表
     */
    public static final String INTERFACEID_QL_20013 = "ql-20013";

    /**
     * 按订货开单详情
     */
    public static final String INTERFACEID_QF_20013_1 = "qf-20013-1";

    /**
     * 按订货开单 保存
     */
    public static final String INTERFACEID_SF_20013_1 = "sf-20013-1";
    /**
     * 储值支付
     */
    public static final String INTERFACEID_EC_CUSTOM_STORE_SHOP = "ec-fin-acct-getCustStoredInShop";
    /**
     * 因为二代接口和一代接口有区别  公用参数可能字段不一样
     * 所有的二代接口必须在这里注册
     * @return
     */
    public static List<String> G2List(){
        List<String> list = new ArrayList<>();
        list.add(INTERFACEID_PRINT_DICT_PARAMS);
        list.add(INTERFACEID_EC_CUSTOM_STORE_SHOP);
        return list;
    }
}
