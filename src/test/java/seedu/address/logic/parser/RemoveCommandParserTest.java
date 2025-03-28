package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalNrics.NRIC_VALID_FIRST;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.RemoveCommand;

/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the RemoveCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the RemoveCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class RemoveCommandParserTest {

    private final RemoveCommandParser parser = new RemoveCommandParser();

    @Test
    public void parse_validArgs_returnsRemoveCommand() {
        assertParseSuccess(parser, " -IC S3286024I", new RemoveCommand(NRIC_VALID_FIRST));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, RemoveCommand.MESSAGE_USAGE));
    }
}
