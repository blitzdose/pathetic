package xyz.ollieee.api.pathing.strategy.strategies;

import xyz.ollieee.api.pathing.strategy.PathfinderStrategy;
import xyz.ollieee.api.snapshot.SnapshotManager;
import xyz.ollieee.api.wrapper.PathBlock;
import xyz.ollieee.api.wrapper.PathLocation;

/**
 * A {@link PathfinderStrategy} to find the best walkable path.
 */
public class WalkablePathfinderStrategy implements PathfinderStrategy {

    private final int height;

    private PathLocation lastExamined;

    public WalkablePathfinderStrategy() {
        this(2);
    }

    public WalkablePathfinderStrategy(int height) {
        this.height = height;
    }

    @Override
    public boolean isValid(PathLocation location, SnapshotManager snapshotManager) {

        PathBlock block = snapshotManager.getBlock(location);
        PathBlock blockBelow = snapshotManager.getBlock(location.add(0, -1, 0));

        boolean areBlocksAbovePassable = true;
        for (int i = 1; i < height; i++) {
            PathBlock blockAbove = snapshotManager.getBlock(location.add(0, i, 0));
            if (!blockAbove.isPassable()) {
                areBlocksAbovePassable = false;
                break;
            }
        }

        boolean canStandOnIt = block.isPassable() && blockBelow.isSolid() && areBlocksAbovePassable;

        if(canStandOnIt) {
            this.lastExamined = location;
            return true;
        }

        if(lastExamined != null) {

            double distance = lastExamined.distance(location);
            boolean withinDistance = distance <= 3;

            if(withinDistance && lastExamined.getY() - location.getY() < -2) // if its going up
                return true;

            return withinDistance && lastExamined.getY() - location.getY() > 2; // if its going down
        }

        return false;
    }

    @Override
    public void cleanup() {
        lastExamined = null;
    }
}
