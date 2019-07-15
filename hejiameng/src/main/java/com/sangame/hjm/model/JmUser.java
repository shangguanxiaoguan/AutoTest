package com.sangame.hjm.model;

import lombok.Data;

@Data
public class JmUser {
   private int id;
   private String created_at;
   private String updated_at;
   private String creator;
   private String modifier;
   private int cngold_id;
   private String nickname;
   private String photo;
   private String name;
   private int gender;
   private String mobile;
   private String area;
   private Integer delete_flag;
}
