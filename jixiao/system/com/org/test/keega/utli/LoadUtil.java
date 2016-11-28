package com.org.test.keega.utli;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.org.test.keega.model.Target;

public class LoadUtil {

    /**
     * 特别注意：表名需与对象名相同才能使用
     *
     * @param jdbc Spring JdbcTemplate
     * @param id   要加载的对象的id
     * @param clz  要加载的对象的类型
     * @return
     */
    public static final Object load(JdbcTemplate jdbc, String id, final Class<?> clz) {
        Object oo = jdbc.queryForObject(
                "select * from " + clz.getSimpleName() + " where id = " + id + "", new RowMapper<Object>() {
                    public Object mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        Object o = null;
                        try {
                            o = clz.newInstance();
                            SetParameter.setParameter(o, rs);
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        return o;
                    }
                });
        return oo;
    }

    /**
     * 初始化
     *
     * @param jdbc
     * @param id
     * @param clz
     * @return
     */
/*	public static final Object getInitClassByA0100(JdbcTemplate jdbc ,String a0100,InitClass){
        String sql = "select B0110 ,E0122 ,E01A1,'Usr' as NBASE,A0100 ,A0101 from "+"UsrA01"+" where a0100 = '"+a0100+"'";
System.out.println(sql);
		Object oo = jdbc.queryForObject(
				"select B0110 ,E0122 ,E01A1,'Usr' as NBASE,A0100 ,A0101 from UsrA01 where a0100 = '"+a0100+"'",new RowMapper<Object>() {
					public Object mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Object o = null;
						try {
							o = clz.newInstance();
							
							//SetParameter.setParameter(o, rs);
						} catch (InstantiationException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
						return o;
					}
				});
System.out.println(oo);
		return oo;
	}*/


    //evaluation
    public static final Object loadById(JdbcTemplate jdbc, String id, final Class<?> clz) {
        Object oo = jdbc.queryForObject(
                "select * from " + "per_target_evaluation" + " where id = " + id + "", new RowMapper<Object>() {
                    public Object mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        Object o = null;
                        try {
                            o = clz.newInstance();
                            SetParameter.setParameter(o, rs);
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        return o;
                    }
                });
        return oo;
    }

    //evaluation
    public static final Object loadByP0400(JdbcTemplate jdbc, String p0400, final Class<?> clz) {
//System.out.println("select * from "+"per_target_evaluation"+" where p0400 = "+p0400+"");
        int checkIsHasEva = jdbc.queryForObject(
                "select count(*) from per_target_evaluation where p0400 = ?", Integer.class, p0400);
//System.out.println(checkIsHasEva);
        if (checkIsHasEva != 0) {
            Object oo = jdbc.queryForObject(
                    "select * from " + "per_target_evaluation" + " where p0400 = " + p0400 + "", new RowMapper<Object>() {
                        public Object mapRow(ResultSet rs, int rowNum)
                                throws SQLException {
                            Object o = null;
                            try {
                                o = clz.newInstance();
                                SetParameter.setParameter(o, rs);
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                            return o;
                        }
                    });
            return oo;
        } else {
            return null;
        }
    }

    //evaluation
    public static final Object loadSelfByP0400(JdbcTemplate jdbc, String mainbodyid, String objectid, String planid, String p0400, final Class<?> clz) {
//System.out.println("select count(*) from per_target_evaluation pte where object_id = '"+objectid+"' and plan_id = '"+planid+"' and mainbody_id = '"+mainbodyid+"' and p0400 = '"+p0400+"'");		
        int checkIsHasEva = jdbc.queryForObject(
                "select count(*) from per_target_evaluation pte where object_id = '" + objectid + "' and plan_id = '" + planid + "' and mainbody_id = '" + mainbodyid + "' and p0400 = ?", Integer.class, p0400);
        if (checkIsHasEva != 0) {
            String sql = "select * from per_target_evaluation pte where object_id = '" + objectid + "' and plan_id = '" + planid + "' and mainbody_id = '" + mainbodyid + "' and p0400 = '" + p0400 + "'";
            Object oo = jdbc.queryForObject(sql, new RowMapper<Object>() {
                public Object mapRow(ResultSet rs, int rowNum)
                        throws SQLException {
                    Object o = null;
                    try {
                        o = clz.newInstance();
                        SetParameter.setParameter(o, rs);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return o;
                }
            });
            return oo;
        } else {
            return null;
        }
    }

    //evaluation
    public static final Object loadOtherByP0400(JdbcTemplate jdbc, String mainbodyid, String objectid, String p0400, String planid, final Class<?> clz) {
//System.out.println("select count(*) from per_target_evaluation pte where object_id = '"+objectid+"' and plan_id = '"+planid+"' and mainbody_id = '"+mainbodyid+"' and p0400 = '"+p0400+"'");		
        int checkIsHasEva = jdbc.queryForObject(
                "select count(*) from per_target_evaluation pte where object_id = '" + objectid + "' and plan_id = '" + planid + "' and mainbody_id = '" + mainbodyid + "' and p0400 = ?", Integer.class, p0400);
        if (checkIsHasEva != 0) {
            String sql = "select * from per_target_evaluation pte where object_id = '" + objectid + "' and plan_id = '" + planid + "' and mainbody_id = '" + mainbodyid + "' and p0400 = '" + p0400 + "'";
            Object oo = jdbc.queryForObject(sql, new RowMapper<Object>() {
                public Object mapRow(ResultSet rs, int rowNum)
                        throws SQLException {
                    Object o = null;
                    try {
                        o = clz.newInstance();
                        SetParameter.setParameter(o, rs);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return o;
                }
            });
            return oo;
        } else {
            return null;
        }
    }

    //commonScore
    public static final Object getCommonScoreByPointId(JdbcTemplate jdbc
            , String point_id, int plan_id, String object_id,String mainbodyid, final Class<?> clz) {
       // System.out.println("poin_id:" + plan_id + "-----" + "plan_id:" + plan_id + "------object_id:" + object_id);
       // System.out.println("sql:" + "select count(*) from per_table_" + plan_id + " where object_id = '" + object_id + "' and point_id = ?");
      //  System.out.println("sql:" + "select * from per_table_" + plan_id + " where object_id = '" + object_id + "' and point_id = '" + point_id + "'");
        int checkIsHasEva = jdbc.queryForObject(
                "select count(*) from per_table_" + plan_id + " where object_id = '" + object_id + "' and mainbody_id = '"+mainbodyid+"' and point_id = ?", Integer.class, point_id);
        if (checkIsHasEva != 0) {
            String sql = "select * from per_table_" + plan_id + " where object_id = '" + object_id + "' and mainbody_id = '"+mainbodyid+"' and point_id = '" + point_id + "'";
            Object oo = jdbc.queryForObject(sql, new RowMapper<Object>() {
                public Object mapRow(ResultSet rs, int rowNum)
                        throws SQLException {
                    Object o = null;
                    try {
                        o = clz.newInstance();
                        SetParameter.setParameter(o, rs);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return o;
                }
            });
            return oo;
        } else {
            return null;
        }
    }

    public static final Object getCommonScoreByPointId1(JdbcTemplate jdbc
            , String point_id, int plan_id, String object_id,String mainbodyid, final Class<?> clz) {//String newBody,
        int checkIsHasEva = jdbc.queryForObject(//这里已经写死查询张碧林的分数了。
                "select count(*) from per_table_" + plan_id + "" +
                        " where object_id = '" + object_id + "' and mainbody_id = " +
                        "(select mainbody_id from per_mainbody " +
                        "where body_id = 25 and plan_id = "+plan_id+" and object_id = '"+object_id+"') "+" and point_id = ?", Integer.class, point_id);
        if (checkIsHasEva != 0) {
            String sql = "select * from per_table_" + plan_id + "" +
                    " where object_id = '" + object_id + "' and mainbody_id = " +
                    "(select mainbody_id from per_mainbody " +
                    "where body_id = 25 and plan_id = "+plan_id+" and object_id = '"+object_id+"') "+" and point_id = '" + point_id + "'";
            Object oo = jdbc.queryForObject(sql, new RowMapper<Object>() {
                public Object mapRow(ResultSet rs, int rowNum)
                        throws SQLException {
                    Object o = null;
                    try {
                        o = clz.newInstance();
                        SetParameter.setParameter(o, rs);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return o;
                }
            });
            return oo;

        } else {
            return null;
        }
    }

    /**
     * 特别注意：表名需与对象名相同才能使用
     *
     * @param jdbc Spring JdbcTemplate
     * @param id   要加载的对象的id
     * @param clz  要加载的对象的类型
     * @return
     */
    public static final Object loadP0400(JdbcTemplate jdbc, String id, final Class<?> clz) {
        Object oo = jdbc.queryForObject(
                "select * from " + clz.getSimpleName() + " where p0400 = " + id + "", new RowMapper<Object>() {
                    public Object mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        Object o = null;
                        try {
                            o = clz.newInstance();
                            SetParameter.setParameter(o, rs);
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        return o;
                    }
                });
        return oo;
    }

    public static final Object loadSecondP04(JdbcTemplate jdbc, String id, final Class<?> clz, String tableName) {
        Object oo = jdbc.queryForObject(
                "select * from " + tableName + " where p0400 = " + id + "", new RowMapper<Object>() {
                    public Object mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        Object o = null;
                        try {
                            o = clz.newInstance();
                            SetParameter.setParameter(o, rs);
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        return o;
                    }
                });
        return oo;
    }


    public static final List<Target> loadByDesc1(JdbcTemplate jdbc, final Class<?> clz, String desc1) {
        String ss = "select * from " + clz.getSimpleName() + " where desc1 like '%" + desc1 + "%'";
        List<Target> oo = jdbc.query(ss, new RowMapper<Target>() {
            public Target mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                Object o = null;
                try {
                    o = clz.newInstance();
                    SetParameter.setParameter(o, rs);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return (Target) o;
            }
        });
        return oo;
    }


    /**
     * 查找所有目标中的id,desc1字段的target对象
     *
     * @param jdbc
     * @param clz
     * @return
     */
    public static final List<Target> findAllDesc1AndId(JdbcTemplate jdbc, final Class<?> clz) {
        String ss = "select * from " + clz.getSimpleName() + "";
        List<Target> oo = jdbc.query(ss, new RowMapper<Target>() {
            public Target mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                Target o = null;
                o = new Target();
                o.setDesc1(rs.getString("desc1"));
                o.setId(rs.getInt("id"));
                return o;
            }
        });
        return oo;
    }
}
