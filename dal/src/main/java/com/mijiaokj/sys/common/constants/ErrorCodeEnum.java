package com.mijiaokj.sys.common.constants;

/**
 * Created by sunchenguang on 2017/5/31.
 */

import com.google.common.collect.ImmutableMap;

/**
 * 错误码枚举
 *
 * @author <a href="mailto:qianjun.fgj@taobao.com">千钧</a>
 * @version 1.0
 * @since 2014年9月22日
 */
public enum ErrorCodeEnum {

    SystemError(101, "亲，系统开小差了，请稍后再试"),
    NoPermission(102, "亲，您没有操作权限"),
    IllegalArguments(103, "亲，请检查您的输入"),
    TooLongIptStr(104, "亲，输入内容太长了"),
    TooLongTimeInternal(105, "亲，输入时间间隔太长了"),
    NoValidWorkOrderTask(106, "亲，操作失败，该任务无效"),
    NoValidWorkOrder(107, "亲，操作失败，该工单无效"),
    DealerNotExist(108, "亲，该处理人不存在"),
    NoReceiver(109, "亲，没找到有处理权限的接单人"),
    DealerNotAuthority(110, "亲，您指定的处理人没有权限，请给他授权"),
    TooManyAttaches(111, "亲，最多只能上传三个附件"),
    TooLargeAttach(112, "亲，每个附件大小不能超出2M"),
    AssignSelfError(113, "亲，不能指派给自己"),
    SingleAssignSelfFailue(114, "亲，申领失败了"),
    SingleAssignFailue(115, "亲，指派失败了"),
    NoWorkOrderSelected(116, "亲，您需要选中工单"),
    NoValidWorkOrders(1117, "亲，请选中有效的工单"),
    ActorNotExist(118, "用户不存在"),
    NoAccTimeLock(119, "赔付审批单不存在"),

    CompensateRuleIsNull(200,"亲，赔付规则为空"),
    CompenTypeCodeIsNull(201,"亲，赔付规则的赔付类型code为空"),
    CompenCreateIsFail(202,"亲，赔付工单创建失败"),
    CaiNiaoBailNot(203,"亲，赔付工单创建失败，菜鸟保证金赔付目前不支持"),
    PayTypeError(204,"亲，赔付工单创建失败，目前只支持保证金和收入抵扣模式"),
    CaiNiaoToSellError(205,"亲，赔付工单创建失败，菜鸟赔付商家失败,请手工处理"),
    NoValidOrDealerNotAuthority(206,"亲，存在无效工单,或者您指定的处理人没有权限"),
    TimeRangeInvert(207,"亲，输入的开始时间要小于结束时间"),
    MessageNotEmpty(208,"亲，输入的留言不能为空"),
    ApproveFailure(209, "亲，审批失败了"),
    NoTransferPermission(210, "亲，您没有转交权限"),
    NoAcceptorPermission(211, "亲，您指定的接单人没有处理权限"),

    ResultNotExisit(301, "查询结果为空"),
    ParamIsNotNull(302, "亲，入参必填项不能为空"),
    FileIsFail(303, "上传附件失败"),
    CheckSuccess(304, "判定操作成功"),
    CheckIsFail(305, "判定操作失败"),
    memoCanNotChinese(306, "留言不能填写中文字符"),
    memoCanNotEmpty(307,"亲，输入的备注不能为空"),

    queryLogisticFailue(401,"查询物流商品失败"),
    queryPriceDefineFailue(402,"查询报价定义失败"),
    queryQuotedPriceFailue(403,"查询报价版本失败"),
    queryCalcTemplateFailue(404,"查询费用项失败"),
    queryEventInstanceFailue(405,"查询费用与事件实例失败"),
    extractMetaDataFailue(406,"提取用到的元数据失败"),
    queryMetaDataFailue(407,"查询元数据失败"),
    queryUserIdFailue(408,"根据用户昵称查询userId失败"),
    queryLogisticResourceFailue(409,"查询物流商品绑定资源失败"),
    queryMetaDataNotExit(410,"元数据不存在"),

    quotedPriceNull(501,"查询报价版本为空"),

    ruleMetaDataNotExit(601,"ruleMetadata中存在未知标识符"),
    MetaDataTypeNotExit(602,"meta的dataType不在5种基本类型中"),
    MetaDataIsNull(603,"获取的meta数据为null"),

    preChargeException(701,"预结算执行异常"),

    repushException(901,"预跑重推接口异常")

    ;

    private static final ImmutableMap<String/* code */, ErrorCodeEnum> codeMapping;
    private static final ImmutableMap<Integer/* key */, ErrorCodeEnum> keyMapping;

    static {
        ImmutableMap.Builder<String, ErrorCodeEnum> builder1 = ImmutableMap.builder();
        ImmutableMap.Builder<Integer, ErrorCodeEnum> builder2 = ImmutableMap.builder();
        for (ErrorCodeEnum errorCodeEnum : values()) {
            builder1.put(errorCodeEnum.getCode(), errorCodeEnum);
            builder2.put(errorCodeEnum.getKey(), errorCodeEnum);
        }
        codeMapping = builder1.build();
        keyMapping = builder2.build();
    }

    private int key;
    private String message;

    private ErrorCodeEnum(int key, String message) {
        this.key = key;
        this.message = message;
    }

    public int getKey() {
        return key;
    }

    public String getCode() {
        return this.name();
    }

    public String getMessage() {
        return message;
    }

    public static ImmutableMap<String, ErrorCodeEnum> getCodemapping() {
        return codeMapping;
    }

    public static ImmutableMap<Integer, ErrorCodeEnum> getKeymapping() {
        return keyMapping;
    }

    public static String getMessageByName(String name){
        for(ErrorCodeEnum ece : ErrorCodeEnum.values()){
            if(ece.name().equals(name)){
                return ece.getMessage();
            }
        }
        return null;
    }

}
