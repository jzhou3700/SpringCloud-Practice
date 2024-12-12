package com.atguigu.cloud;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 
 * @TableName t_storage
 */
@TableName(value ="t_storage")
public class t_storage implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long productId;

    /**
     * 
     */
    private Integer total;

    /**
     * 
     */
    private Integer used;

    /**
     * 
     */
    private Integer residue;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * 
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 
     */
    public Integer getUsed() {
        return used;
    }

    /**
     * 
     */
    public void setUsed(Integer used) {
        this.used = used;
    }

    /**
     * 
     */
    public Integer getResidue() {
        return residue;
    }

    /**
     * 
     */
    public void setResidue(Integer residue) {
        this.residue = residue;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        t_storage other = (t_storage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getTotal() == null ? other.getTotal() == null : this.getTotal().equals(other.getTotal()))
            && (this.getUsed() == null ? other.getUsed() == null : this.getUsed().equals(other.getUsed()))
            && (this.getResidue() == null ? other.getResidue() == null : this.getResidue().equals(other.getResidue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getTotal() == null) ? 0 : getTotal().hashCode());
        result = prime * result + ((getUsed() == null) ? 0 : getUsed().hashCode());
        result = prime * result + ((getResidue() == null) ? 0 : getResidue().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", total=").append(total);
        sb.append(", used=").append(used);
        sb.append(", residue=").append(residue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}