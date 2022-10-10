package maze;

/** a enum type that represents the walls surrounding the cell */
public enum Wall {

  /** north wall */
  NORTH,
  /** east wall */
  EAST,
  /** south wall */
  SOUTH,
  /** west wall */
  WEST;

  public String toString() {
    String res = null;
    if(this == NORTH)
      res = "North";
    if(this == SOUTH)
      res = "South";
    if(this == EAST)
      res = "East";
    if(this == WEST)
      res = "West";
    return res;
  }

}
