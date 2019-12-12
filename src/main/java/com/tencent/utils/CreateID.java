package com.tencent.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成全局唯一ID的工具
 *
 * 1、全局唯一
 * 2、不能有敏感的业务信息
 * 3、抗并发
 * 4、不宜过长（10-15）
 *
 * 当前时间（年月日时分秒）
 * 用户的后4位（不足4位的补0）
 * 流水号1-n    redis set number 1  incr number ->2
 *
 */
@Component
public class CreateID {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 生成ID
     */
    public String createID(Integer uid){
        StringBuffer stringBuffer = new StringBuffer();
        //时间格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmsss");
        String time = simpleDateFormat.format(new Date());
        stringBuffer.append(time);

        //用户id不足4位进行补0，大于等于4位取出拼接
        String userId = uid+"";
        //判断
        if(userId.length()<4){//不足4位
            for (int i = 0; i < 4-userId.length(); i++) {
                stringBuffer.append("0");
            }
            stringBuffer.append(userId);
        }else{//大于等于4位
            String substring = userId.substring(userId.length() - 4);//下标从0开始,
            stringBuffer.append(substring);
        }

        //流水号创建，先取出->没有进行生成，然后流水号自增
       /* String orderNum= redisTemplate.opsForValue().get("order_num");
        if(orderNum == null){//为空
            redisTemplate.opsForValue().set("order_num","0");
        }
        //获取自增的流水号
        Long order_num = redisTemplate.opsForValue().increment("order_num");*/
//        stringBuffer.append(order_num);
        stringBuffer.append(1);
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        CreateID createID = new CreateID();
        String cid = createID.createID(2344);
        System.out.println("生成的id:"+cid+",长度:"+cid.length());//刚好一个bigint
    }


















}



