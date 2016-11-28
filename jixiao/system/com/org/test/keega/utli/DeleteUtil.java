package com.org.test.keega.utli;

import org.springframework.jdbc.core.JdbcTemplate;

import com.org.test.keega.model.Evaluation;

public class DeleteUtil {
	/**
	 * 特别注意：添加的表名为 对象的名才能使用
	 * @param clz 要删除的表名的对应对象名
	 * @param id 删除id
	 * @param jdbcTemplate Spring的jdbcTemplate
	 */
	public static final void delete(Class<?> clz,int id ,JdbcTemplate jdbcTemplate){
		jdbcTemplate.update("delete from "+clz.getSimpleName()+" where id = ?", id);
	}
	
	public static final void deleteP0400(Class<?> clz,int id ,JdbcTemplate jdbcTemplate){
		jdbcTemplate.update("delete from "+clz.getSimpleName()+" where p0400 = ?", id);
		//删除之后要把相应的评价删除
		deleteEvalution(Evaluation.class, id+"", jdbcTemplate);
	}
	
	public static final void deleteP0400s(Class<?> clz,String id ,JdbcTemplate jdbcTemplate){
		jdbcTemplate.update("delete from "+"p04"+" where p0400 = ?", id);
		//删除之后要把相应的评价删除
		deleteEvalution(Evaluation.class, id+"", jdbcTemplate);
	}
	
	public static final void deleteEvalution(Class<?> clz,String p0400 ,JdbcTemplate jdbcTemplate){
		jdbcTemplate.update("delete from "+"per_target_evaluation "+" where per_target_evaluation.object_id = per_target_evaluation.mainbody_id and per_target_evaluation.p0400 = ?", p0400);
		jdbcTemplate.update("delete from "+"per_target_evaluation "+" where per_target_evaluation.object_id != per_target_evaluation.mainbody_id and per_target_evaluation.p0400 = ?", p0400);
	}
	
	
}
