package com.elfe.arfactory.admin.predicate;

import com.elfe.arfactory.promotion.entity.QAf_project_info_1Entity;
import com.querydsl.core.BooleanBuilder;

public class ASolutionPredicate {

    public static BooleanBuilder search(String selectKey, String titleText){
        QAf_project_info_1Entity qAf_project_info_1Entity = QAf_project_info_1Entity.af_project_info_1Entity;

        BooleanBuilder builder = new BooleanBuilder();
        System.out.println(titleText);
        if(!selectKey.equals("전체")){
            if(selectKey.equals("No")){
                builder.and(qAf_project_info_1Entity.API1_SEQ.eq(Long.valueOf(titleText)));
            }
            else if(selectKey.equals("패키지 이름")){
                builder.and(qAf_project_info_1Entity.API1_NAME.contains(titleText));
            }
            else if(selectKey.equals("패키지 타입")){
                builder.and(qAf_project_info_1Entity.API1_TYPE.contains(titleText));
            }
        }
        else if(selectKey.equals("전체")){
            try{
                builder.and(qAf_project_info_1Entity.API1_SEQ.eq(Long.valueOf(titleText)));
            }
            catch (Exception e){
                builder.and(
                        (qAf_project_info_1Entity.API1_NAME.contains(titleText)).or
                                (qAf_project_info_1Entity.API1_TYPE.contains(titleText)));
            }
        }

        return builder;
    }
}
