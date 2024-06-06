package at.htl.leonding.feature.home;

import at.htl.leonding.model.UIState;

/** the model for our HomeView, which only knows
 * about a list of todos a text and the orientation */
public record HomeModel(
        int numberOfToDos,
        String greetingText,
        UIState.Orientation orientation
) {}