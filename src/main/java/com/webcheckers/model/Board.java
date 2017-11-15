package com.webcheckers.model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Board implements Iterable<Row>{

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    private List<Row> rows;

    public boolean isDidMove(com.webcheckers.model.Move testMove) {
        return didMove;
    }

    public void setDidMove(boolean didMove) {
        this.didMove = didMove;
    }

    private boolean didMove = false;

    public boolean isDidJump() {
        return didJump;
    }

    public void setDidJump(boolean didJump) {
        this.didJump = didJump;
    }

    private boolean didJump = false;



    private boolean Move = false;
    public boolean isMove() {
        return Move;
    }

    public Board() {
        rows = new ArrayList<>();
        for(int i=0; i<=7; i++) {
            rows.add(new Row(i));
        }
    }

    public void setMove(boolean move) {
        this.Move = move;
    }

    public void movePiece(Move _move) {

        Space startSpace = fetchSpace(_move.getStart());
        Space endSpace = fetchSpace(_move.getEnd());
        Piece piece = startSpace.getPiece();
        startSpace.setPiece(null);
        endSpace.setPiece(piece);
        didMove = true;

        if(_move.getRowsMoved() == 2) {
            didJump = true;
            Position jumpedPosition = _move.getPosition();
            Space jumpedSpace = fetchSpace(jumpedPosition);
            jumpedSpace.removeCapturedPiece();
        }
    }

    @Override
    public Iterator<Row> iterator() {
        return rows.iterator();
    }

    public Message validateMove(Move move) {

        Space startSpace = fetchSpace(move.getStart());
        Space endSpace = fetchSpace(move.getEnd());
        Piece piece = startSpace.getPiece();


        if(move.getRowsMoved() == 1 && piece.getColor().equals("RED") && redJumps()) {
            return new Message("A jump needs to be taken", "error");
        } else if(move.getRowsMoved() == 1 && piece.getColor().equals("WHITE") && WhiteJumps()) {
            return new Message("A jump needs to be taken", "error");
        }

        if(!didMove || (didMove && didJump)) {
            if(endSpace.getPiece() == null) {
                if (piece.getColor().equals("RED")) {
                    if (move.getRowsMoved() == 1 && !move.isMoveUp() && !didJump) {
                        return new Message("Move Allowed", "info");
                    } else if(move.getRowsMoved() == 2 && !move.isMoveUp()) {
                        return validateJump(move, piece);
                    } else {
                        String messageText = didJump ? "Not Allowed" : "move 1 row forward";
                        return new Message(messageText, "error");
                    }
                } else if (piece.getColor().equals("WHITE")) {
                    if (move.getRowsMoved() == 1 && move.isMoveUp() && !didJump) {
                        return new Message("Move Allowed", "info");
                    } else if(move.getRowsMoved() == 2 && move.isMoveUp()) {
                        return validateJump(move, piece);
                    } else {
                        String messageText = didJump ? "Not Allowed" : "move 1 row forward";
                        return new Message(messageText, "error");
                    }
                }
            } else {
                return new Message("Not Allowed", "error");
            }
        } else {
            return new Message("Not Allowed", "error");
        }


        return new Message("Move not Allowed", "error");
    }


    public Message validateJump(Move move, Piece piece) {

        Position jumpedPosition = move.getPosition();
        Space jumpedSpace = fetchSpace(jumpedPosition);
        Piece jumpedPiece = jumpedSpace.getPiece();

        if(jumpedPiece != null) {
            if(!jumpedPiece.getColor().equals(piece.getColor())) {
                return new Message("Move allowed", "info");
            } else {
                return new Message("You cannot jump your own piece", "error");
            }
        } else {
            return new Message("An empty square in skipped", "error");
        }
    }

    public void undoMove(Move move) {
        Space startSpace = fetchSpace(move.getStart());
        Space endSpace = fetchSpace(move.getEnd());
        Piece piece = endSpace.getPiece();
        startSpace.setPiece(piece);
        endSpace.setPiece(null);
        didMove = false;
    }
    public void undoCapture(Space space, Piece capturedPiece, int count) {
        space.setPiece(capturedPiece);

        if(count == 0) {
            didJump = false;
        }
    }

    public Space fetchSpace(Position position) {
        return rows.get(position.getRow()).getSpaces().get(position.getCell());
    }

    public boolean redJumps() {
        for(Row row: rows) {
            for(Space space : row) {
                Piece piece = space.getPiece();


                if(piece != null && piece.getColor().equals("RED")) {
                    if (row.getIndex() > 1) {
                        if (space.getCellIdx() <= 1) {
                            Space squareToJump = fetchSpace(new Position(row.getIndex() - 1, space.getCellIdx() + 1));
                            Space landingSquare = fetchSpace(new Position(row.getIndex() - 2, space.getCellIdx() + 2));

                            Piece jumpedPiece = squareToJump.getPiece();
                            Piece landingSquarePiece = landingSquare.getPiece();


                            if (jumpedPiece != null && jumpedPiece.getColor().equals("WHITE") && landingSquarePiece == null) {
                                return true;
                            }
                        } else if (space.getCellIdx() >= 6) {
                            Space squareToJump = fetchSpace(new Position(row.getIndex() - 1, space.getCellIdx() - 1));
                            Space landingSquare = fetchSpace(new Position(row.getIndex() - 2, space.getCellIdx() - 2));

                            Piece jumpedPiece = squareToJump.getPiece();
                            Piece landingSquarePiece = landingSquare.getPiece();

                            if (jumpedPiece != null && jumpedPiece.getColor().equals("WHITE") && landingSquarePiece == null) {
                                return true;
                            }
                        } else {
                            Space squareToJumpLeft = fetchSpace(new Position(row.getIndex() - 1, space.getCellIdx() - 1));
                            Space landingSquareLeft = fetchSpace(new Position(row.getIndex() - 2, space.getCellIdx() - 2));
                            Piece jumpedPieceLeft = squareToJumpLeft.getPiece();
                            Piece landingSquarePieceLeft = landingSquareLeft.getPiece();

                            Space squareToJumpRight = fetchSpace(new Position(row.getIndex() - 1, space.getCellIdx() + 1));
                            Space landingSquareRight = fetchSpace(new Position(row.getIndex() - 2, space.getCellIdx() + 2));
                            Piece jumpedPieceRight = squareToJumpRight.getPiece();
                            Piece landingSquarePieceRight = landingSquareRight.getPiece();


                            if (jumpedPieceLeft != null && jumpedPieceLeft.getColor().equals("WHITE") && landingSquarePieceLeft == null) {
                                return true;
                            } else if (jumpedPieceRight != null && jumpedPieceRight.getColor().equals("WHITE") && landingSquarePieceRight == null) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }


    public boolean WhiteJumps() {
        for(Row row: rows) {
            for(Space space : row) {
                Piece piece = space.getPiece();

                if(piece != null && piece.getColor().equals("WHITE")) {
                    if (row.getIndex() < 6) {
                        if (space.getCellIdx() <= 1) {
                            Space squareToJump = fetchSpace(new Position(row.getIndex() + 1, space.getCellIdx() + 1));
                            Space landingSquare = fetchSpace(new Position(row.getIndex() + 2, space.getCellIdx() + 2));

                            Piece jumpedPiece = squareToJump.getPiece();
                            Piece landingSquarePiece = landingSquare.getPiece();

                            if (jumpedPiece != null && jumpedPiece.getColor().equals("RED") && landingSquarePiece == null) {
                                return true;
                            }
                        } else if (space.getCellIdx() >= 6) {
                            Space squareToJump = fetchSpace(new Position(row.getIndex() + 1, space.getCellIdx() - 1));
                            Space landingSquare = fetchSpace(new Position(row.getIndex() + 2, space.getCellIdx() - 2));

                            Piece jumpedPiece = squareToJump.getPiece();
                            Piece landingSquarePiece = landingSquare.getPiece();

                            if (jumpedPiece != null && jumpedPiece.getColor().equals("RED") && landingSquarePiece == null) {
                                return true;
                            }
                        } else {
                            Space squareToJumpLeft = fetchSpace(new Position(row.getIndex() + 1, space.getCellIdx() + 1));
                            Space landingSquareLeft = fetchSpace(new Position(row.getIndex() + 2, space.getCellIdx() + 2));
                            Piece jumpedPieceLeft = squareToJumpLeft.getPiece();
                            Piece landingSquarePieceLeft = landingSquareLeft.getPiece();

                            Space squareToJumpRight = fetchSpace(new Position(row.getIndex() + 1, space.getCellIdx() - 1));
                            Space landingSquareRight = fetchSpace(new Position(row.getIndex() + 2, space.getCellIdx() - 2));
                            Piece jumpedPieceRight = squareToJumpRight.getPiece();
                            Piece landingSquarePieceRight = landingSquareRight.getPiece();

                            if (jumpedPieceLeft != null && jumpedPieceLeft.getColor().equals("RED") && landingSquarePieceLeft == null) {
                                return true;
                            } else if (jumpedPieceRight != null && jumpedPieceRight.getColor().equals("RED") && landingSquarePieceRight == null) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

}