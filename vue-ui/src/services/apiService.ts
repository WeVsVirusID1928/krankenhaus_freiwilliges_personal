import {HelpingHand} from "@/interfaces/types";
import {defaultClient} from "@/clients/default";


export const registerHelpingHand = async (
    person: HelpingHand,
): Promise<any> => {
    // some validation?
    console.log(person);
    return defaultClient.post('/register', person);
};