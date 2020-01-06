package com.baomidou.test.student.store.domain;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yaoyige
 * @since 2020-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sId;

    private String cId;

    private Integer sScore;


}
