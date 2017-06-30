package model;

import model.Field.Symbol;

public class Field{
	private Symbol owner;

    /**
     * Initializes the Field object with a Symbol.
     * 
     * @param symbol    a Symbol (O, or NONE)
     */
    private Field(Symbol symbol) {
        owner = symbol;
    }

    /**
     * Static factory, returns a Field object with Symbol.NONE.
     */
    public static Field getDefault() {
        return new Field(Symbol.O);
    }
    public static Field getNone() {
        return new Field(Symbol.NONE);
    }

    /**
     * Returns the owner of a field as a Symbol.
     * 
     * @return      the owner of a field as a Symbol.
     */
    public Symbol getOwner() {
        return owner;
    }

    /**
     * Sets the owner of a field.
     * 
     * @param owner     a Symbol (O or NONE)
     */
    public void setOwner(Symbol owner) {
        this.owner = owner;
    }

    /**
     * Returns the Symbol (O or NONE) as a String.
     * 
     * @return      the owner of a field as a String.
     */
    @Override
    public String toString() {
        return owner.toString();
    }

    /**
     * A representation of an owner of a field.
     */
    public enum Symbol {
        X,O, NONE
    }
}