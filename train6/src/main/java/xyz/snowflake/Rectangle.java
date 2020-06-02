package xyz.snowflake;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author snowflake
 * @version v1.0
 * @package xyz.snowflake
 * @title Rectangle
 * @description 矩形
 * @date 2020/6/2 - 10:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rectangle {

    private int width;
    private int height;

    public int getArea() {
        return this.width * this.height;
    }

}
