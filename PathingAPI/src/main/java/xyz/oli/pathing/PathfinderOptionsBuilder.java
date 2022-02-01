package xyz.oli.pathing;

import lombok.Builder;
import org.bukkit.Location;

import xyz.oli.pathing.model.path.finder.strategy.PathfinderStrategy;

@Builder
public class PathfinderOptionsBuilder {

    // why is this protected?
    protected Location start;
    protected Location target;
    protected boolean asyncMode;
    protected PathfinderStrategy strategy;

    public PathfinderOptions build() {
        return new PathfinderOptions(this);
    }

}