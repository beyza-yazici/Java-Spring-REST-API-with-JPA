package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import org.springframework.http.HttpStatus;


public class CardValidation {

    public static void validate(Card card) {
        if (card == null) {
            throw new CardException("Card is null", HttpStatus.BAD_REQUEST);
        }

        if (card.getType() != null && "JOKER".equals(card.getType().toString())) {

            if (card.getValue() != null) {
                throw new CardException("JOKER card cannot have a value", HttpStatus.BAD_REQUEST);
            }

            if (card.getColor() != null) {
                throw new CardException("JOKER card cannot have a color", HttpStatus.BAD_REQUEST);
            }

            return;
        }


        if (card.getType() != null && card.getValue() != null) {
            throw new CardException("A card cannot have both type and value", HttpStatus.BAD_REQUEST);
        }


        if (card.getType() == null && card.getValue() == null) {
            throw new CardException("A card must have either a type or a value", HttpStatus.BAD_REQUEST);
        }


        if (card.getType() != null) {
            if (card.getValue() != null) {
                throw new CardException("When type is provided, value must be null", HttpStatus.BAD_REQUEST);
            }
        }


        if (card.getValue() != null) {
            if (card.getType() != null) {
                throw new CardException("When value is provided, type must be null", HttpStatus.BAD_REQUEST);
            }
        }


        if (card.getType() != null && !"JOKER".equals(card.getType().toString()) && card.getColor() == null) {
            throw new CardException("Card color cannot be empty for non-JOKER cards", HttpStatus.BAD_REQUEST);
        }
    }
}
