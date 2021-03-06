package org.jerlang.stdlib.beam_lib;

import org.jerlang.type.Atom;

/**
 * = The Atom Chunk
 *
 * The Atom Chunk stores Atoms - the constant values
 * (including identifiers like the module name and function names).
 * The Atom Chunk is composed of a Header followed by Atom definitions.
 *
 * == Header
 *
 * The Atom Chunk Header is composed of 12 bytes.
 * This is the structure of the Atom Chunk Header:
 *
 * |===
 * |Length |Value |Description
 *
 * |4 bytes|`Atom`|Magic number indicating the Atom Chunk.
 * |4 bytes|size  |Atom Chunk length in bytes
 * |4 bytes|count |Number of atoms in the Atom Chunk
 * |===
 *
 * == Atom Definition Format
 *
 * Each Atom Definition is composed of two items:
 * This is the structure of the Atom Definition:
 *
 * |===
 * |Length|Value  |Description
 *
 * |1 bytes|length|Number of bytes in the Atom
 * |n bytes|atom  |The Atom (in the form of ASCII characters).
 * |===
 *
 * === Restriction
 *
 * * Atoms are limited to 255 characters or less.
 * * Characters must be valid characters in ISO 8859-1.
 *
 * == Requirements
 *
 * * The first Atom to appear in the Atom Chunk must be the module name.
 *
 * Source:
 * https://synrc.com/publications/cat/Functional%20Languages/Erlang/BEAM.pdf
 */
public class AtomChunk extends Chunk {

    private Atom[] atoms;

    public AtomChunk(Chunk chunk, int numberOfAtoms) {
        super(ChunkId.ATOM, chunk);
        atoms = new Atom[numberOfAtoms];
    }

    public void set(int index, Atom atom) {
        atoms[index] = atom;
    }

    public Atom[] atoms() {
        return atoms;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{atom_chunk,[\n    ");
        for (int index = 0; index < atoms.length; index++) {
            stringBuilder.append(atoms[index]).append(",\n    ");
        }
        if (atoms.length > 0) {
            stringBuilder.setLength(stringBuilder.length() - 6);
        }
        stringBuilder.append("]}");
        return stringBuilder.toString();
    }

}
