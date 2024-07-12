package com.kob.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @TableId(type = IdType.AUTO)
    private Integer id;  // 总品类ID
    private String name;  // 总品类名称
    private Integer childId;  // 子品类ID
    private String childName;  // 子品类名称
}
