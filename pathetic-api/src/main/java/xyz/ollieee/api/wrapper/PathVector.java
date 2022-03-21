package xyz.ollieee.api.wrapper;

import lombok.Getter;

@Getter
public class PathVector implements Cloneable {
    
    private double x;
    private double y;
    private double z;

    /**
     * Constructs a PathVector with default 0 values
     */
    public PathVector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    /**
     * Constructs a new PathVector with given values
     * @param x The x value of this vector
     * @param y The y value of this vector
     * @param z The z value of this vector
     */
    public PathVector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Sets the X value of the vector
     * @param x The value to set it to
     * @return The same {@link PathVector}
     */
    public PathVector setX(double x) {
        this.x = x;
        return this;
    }

    /**
     * Sets the Y value of the vector
     * @param y The value to set it to
     * @return The same {@link PathVector}
     */
    public PathVector setY(double y) {
        this.y = y;
        return this;
    }

    /**
     * Sets the Z value of the vector
     * @param z The value to set it to
     * @return The same {@link PathVector}
     */
    public PathVector setZ(double z) {
        this.z = z;
        return this;
    }

    /**
     * Subtracts one vector from another
     * @param otherVector {@link PathVector} to vector to subtract from the current Vector
     * @return The same {@link PathVector}
     */
    public PathVector subtract(PathVector otherVector) {
        this.x -= otherVector.x;
        this.y -= otherVector.y;
        this.z -= otherVector.z;
        return this;
    }

    /**
     * Multiplies itself by a scalar constant
     * @param value The constant to multiply by
     * @return The same {@link PathVector}
     */
    public PathVector multiply(double value) {
        this.x *= value;
        this.y *= value;
        this.z *= value;
        return this;
    }

    /**
     * Clones the {@link PathVector}
     * @return A new {@link PathVector} with the same values
     */
    @Override
    public PathVector clone() {
        return new PathVector(this.x, this.y, this.z);
    }

    /**
     * Normalises the {@link PathVector} (Divides the components by its magnitude)
     * @return The same {@link PathVector}
     */
    public PathVector normalize() {
        double length = this.length();
        this.x /= length;
        this.y /= length;
        this.z /= length;
        return this;
    }

    private double square(double value){
        return value * value;
    }

    /**
     * Gets the length of the vector
     * @return The length
     */
    public double length() {
        return Math.sqrt(this.square(this.x) + this.square(this.y) + this.square(this.z));
    }
}