package game;

/**
 * This class creates a Map object which the game is played on.
 * A Map is an array of Tiles where each Tile has a TileType.
 * 
 * The Map can be set the default map.
 */
public class Map {
    private Tile[][] tiles = new Tile[5][9];

    private final TileType[][] defaultMap = {
        {TileType.PLAIN, TileType.PLAIN, TileType.MOUNTAIN_1, TileType.PLAIN, TileType.RIVER, TileType.PLAIN, TileType.MOUNTAIN_3, TileType.PLAIN, TileType.PLAIN},
        {TileType.PLAIN, TileType.MOUNTAIN_1, TileType.PLAIN, TileType.PLAIN, TileType.RIVER, TileType.PLAIN, TileType.PLAIN, TileType.PLAIN, TileType.MOUNTAIN_3},
        {TileType.MOUNTAIN_3, TileType.PLAIN, TileType.PLAIN, TileType.PLAIN, TileType.TOWN, TileType.PLAIN, TileType.PLAIN, TileType.PLAIN, TileType.MOUNTAIN_1},
        {TileType.PLAIN, TileType.MOUNTAIN_2, TileType.PLAIN, TileType.PLAIN, TileType.RIVER, TileType.PLAIN, TileType.MOUNTAIN_2, TileType.PLAIN, TileType.PLAIN},
        {TileType.PLAIN, TileType.PLAIN, TileType.MOUNTAIN_2, TileType.PLAIN, TileType.RIVER, TileType.PLAIN, TileType.PLAIN, TileType.PLAIN, TileType.MOUNTAIN_2} 
    }

    public Map() {
        tiles = createDefaultMap();
    }

    public Tile[][] createDefaultMap() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 9; col++) {
                tiles[row][col] = new Tile(defaultMap[row][col]);
            }
        }
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }
}
