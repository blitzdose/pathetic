package xyz.oli.api.wrapper;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.bukkit.util.NumberConversions;

import xyz.oli.api.PathingAPI;

@ToString
@EqualsAndHashCode
public class PathLocation implements Cloneable {

    private final PathWorld pathWorld;
    private double x, y, z;
    
    public PathLocation(PathWorld pathWorld, double x, double y, double z) {
        
        this.pathWorld = pathWorld;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public PathWorld getPathWorld() {
        return this.pathWorld;
    }

    public double getX() {
        return this.x;
    }

    public int getBlockX() {
        return (int) Math.floor(this.x);
    }

    public double getY() {
        return this.y;
    }

    public int getBlockY() {
        return (int) Math.floor(this.y);
    }

    public double getZ() {
        return this.z;
    }

    public int getBlockZ() {
        return (int) Math.floor(this.z);
    }

    @Override
    public PathLocation clone() {
        return new PathLocation(this.pathWorld, this.x, this.y, this.z);
    }

    public double distance(PathLocation otherLocation) {
        return Math.sqrt(NumberConversions.square(this.x - otherLocation.x) + NumberConversions.square((this.y - otherLocation.y) * 1.1) + NumberConversions.square(this.z - otherLocation.z));
    }

    public PathLocation add(final double x, final double y, final double z) {
        
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    public PathLocation add(final PathVector vector) {
        add(vector.getX(), vector.getY(), vector.getZ());
        return this;
    }
    
    public PathLocation subtract(final double x, final double y, final double z) {
        
        this.x -= x;
        this.y -= y;
        this.z -= z;
        return this;
    }
    
    public PathLocation subtract(final PathVector vector) {
        subtract(vector.getX(), vector.getY(), vector.getZ());
        return this;
    }

    public PathBlock getBlock() {
        return PathingAPI.getSnapshotManager().getBlock(this);
    }
}
