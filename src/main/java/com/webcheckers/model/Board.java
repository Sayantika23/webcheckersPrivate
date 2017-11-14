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

        Space startSpace = getSpaceByCoordinate(_move.getStart());
        Space endSpace = getSpaceByCoordinate(_move.getEnd());
        Piece piece = startSpace.getPiece();
        startSpace.setPiece(null);
        endSpace.setPiece(piece);
        didMove = true;

        if(_move.getRowsMoved() == 2) {
            didJump = true;
            Position jumpedCoordinate = _move.getJumpedCoordinate();
            Space jumpedSpace = getSpaceByCoordinate(jumpedCoordinate);
            jumpedSpace.removeCapturedPiece();
        }
    }

    @Override
    public Iterator<Row> iterator() {
        return rows.iterator();
    }

    public Message validateMove(Move _move) {

        Space startSpace = getSpaceByCoordinate(_move.getStart());
        Space endSpace = getSpaceByCoordinate(_move.getEnd());
        Piece piece = startSpace.getPiece();


        if(_move.getRowsMoved() == 1 && piece.getColor().equals("RED") && checkForAvailableRedJumps()) {
            return new Message("You have a jump that you must take", "error");
        } else if(_move.getRowsMoved() == 1 && piece.getColor().equals("WHITE") && checkForAvailableWhiteJumps()) {
            return new Message("You have a jump that you must take", "error");
        }

        if(!didMove || (didMove && didJump)) {
            if(endSpace.getPiece() == null) {
                if (piece.getColor().equals("RED")) {
                    if (_move.getRowsMoved() == 1 && !_move.isMoveUp() && !didJump) {
                        return new Message("Move Allowed", "info");
                    } else if(_move.getRowsMoved() == 2 && !_move.isMoveUp()) {
                        return validateJump(_move, piece);
                    } else {
                        String messageText = didJump ? "You cannot make a regular move after jumping!" : "You must move 1 row forward";
                        return new Message(messageText, "error");
                    }
                } else if (piece.getColor().equals("WHITE")) {
                    if (_move.getRowsMoved() == 1 && _move.isMoveUp() && !didJump) {
                        return new Message("Move Allowed", "info");
                    } else if(_move.getRowsMoved() == 2 && _move.isMoveUp()) {
                        return validateJump(_move, piece);
                    } else {
                        String messageText = didJump ? "You cannot make a regular move after jumping!" : "You must move 1 row forward";
                        return new Message(messageText, "error");
                    }
                }
            } else {
                return new Message("A Piece is already in that Square", "error");
            }
        } else {
            return new Message("You have already made a move this turn", "error");
        }


        return new Message("Move not Allowed", "error");
    }


    public Message validateJump(Move _move, Piece _jumpingPiece) {

        Position jumpedCoordinate = _move.getJumpedCoordinate();
        Space jumpedSpace = getSpaceByCoordinate(jumpedCoordinate);
        Piece jumpedPiece = jumpedSpace.getPiece();

        if(jumpedPiece != null) {
            if(!jumpedPiece.getColor().equals(_jumpingPiece.getColor())) {
                return new Message("Move allowed", "info");
            } else {
                return new Message("You cannot jump your own piece", "error");
            }
        } else {
            return new Message("An empty square in skipped", "error");
        }
    }


    public void undoMove(Move _move) {
        Space startSpace = getSpaceByCoordinate(_move.getStart());
        Space endSpace = getSpaceByCoordinate(_move.getEnd());
        Piece piece = endSpace.getPiece();

        //Set the piece back in the starting square and empty the ending square.  Indicate that the user now hasn't completed a move this turn
        startSpace.setPiece(piece);
        endSpace.setPiece(null);
        didMove = false;
    }

    public void undoCapture(Space _jumpedSpace, Piece _capturedPiece, int _stillCapturedCount) {
        _jumpedSpace.setPiece(_capturedPiece);

        if(_stillCapturedCount == 0) {
            didJump = false;
        }
    }


    public Space getSpaceByCoordinate(Position _coord) {
        return rows.get(_coord.getRow()).getSpaces().get(_coord.getCell());
    }


    public boolean checkForAvailableRedJumps() {
        for(Row row: rows) {
            for(Space space : row) {
                Piece piece = space.getPiece();


                if(piece != null && piece.getColor().equals("RED")) {
                    if (row.getIndex() > 1) {
                        if (space.getCellIdx() <= 1) {
                            Space squareToJump = getSpaceByCoordinate(new Position(row.getIndex() - 1, space.getCellIdx() + 1));
                            Space landingSquare = getSpaceByCoordinate(new Position(row.getIndex() - 2, space.getCellIdx() + 2));

                            Piece jumpedPiece = squareToJump.getPiece();
                            Piece landingSquarePiece = landingSquare.getPiece();


                            if (jumpedPiece != null && jumpedPiece.getColor().equals("WHITE") && landingSquarePiece == null) {
                                return true;
                            }
                        } else if (space.getCellIdx() >= 6) {
                            Space squareToJump = getSpaceByCoordinate(new Position(row.getIndex() - 1, space.getCellIdx() - 1));
                            Space landingSquare = getSpaceByCoordinate(new Position(row.getIndex() - 2, space.getCellIdx() - 2));

                            Piece jumpedPiece = squareToJump.getPiece();
                            Piece landingSquarePiece = landingSquare.getPiece();

                            if (jumpedPiece != null && jumpedPiece.getColor().equals("WHITE") && landingSquarePiece == null) {
                                return true;
                            }
                        } else {
                            Space squareToJumpLeft = getSpaceByCoordinate(new Position(row.getIndex() - 1, space.getCellIdx() - 1));
                            Space landingSquareLeft = getSpaceByCoordinate(new Position(row.getIndex() - 2, space.getCellIdx() - 2));
                            Piece jumpedPieceLeft = squareToJumpLeft.getPiece();
                            Piece landingSquarePieceLeft = landingSquareLeft.getPiece();

                            Space squareToJumpRight = getSpaceByCoordinate(new Position(row.getIndex() - 1, space.getCellIdx() + 1));
                            Space landingSquareRight = getSpaceByCoordinate(new Position(row.getIndex() - 2, space.getCellIdx() + 2));
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


    public boolean checkForAvailableWhiteJumps() {
        for(Row row: rows) {
            for(Space space : row) {
                Piece piece = space.getPiece();

                if(piece != null && piece.getColor().equals("WHITE")) {
                    if (row.getIndex() < 6) {
                        if (space.getCellIdx() <= 1) {
                            Space squareToJump = getSpaceByCoordinate(new Position(row.getIndex() + 1, space.getCellIdx() + 1));
                            Space landingSquare = getSpaceByCoordinate(new Position(row.getIndex() + 2, space.getCellIdx() + 2));

                            Piece jumpedPiece = squareToJump.getPiece();
                            Piece landingSquarePiece = landingSquare.getPiece();

                            if (jumpedPiece != null && jumpedPiece.getColor().equals("RED") && landingSquarePiece == null) {
                                return true;
                            }
                        } else if (space.getCellIdx() >= 6) {
                            Space squareToJump = getSpaceByCoordinate(new Position(row.getIndex() + 1, space.getCellIdx() - 1));
                            Space landingSquare = getSpaceByCoordinate(new Position(row.getIndex() + 2, space.getCellIdx() - 2));

                            Piece jumpedPiece = squareToJump.getPiece();
                            Piece landingSquarePiece = landingSquare.getPiece();

                            if (jumpedPiece != null && jumpedPiece.getColor().equals("RED") && landingSquarePiece == null) {
                                return true;
                            }
                        } else {
                            Space squareToJumpLeft = getSpaceByCoordinate(new Position(row.getIndex() + 1, space.getCellIdx() + 1));
                            Space landingSquareLeft = getSpaceByCoordinate(new Position(row.getIndex() + 2, space.getCellIdx() + 2));
                            Piece jumpedPieceLeft = squareToJumpLeft.getPiece();
                            Piece landingSquarePieceLeft = landingSquareLeft.getPiece();

                            Space squareToJumpRight = getSpaceByCoordinate(new Position(row.getIndex() + 1, space.getCellIdx() - 1));
                            Space landingSquareRight = getSpaceByCoordinate(new Position(row.getIndex() + 2, space.getCellIdx() - 2));
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