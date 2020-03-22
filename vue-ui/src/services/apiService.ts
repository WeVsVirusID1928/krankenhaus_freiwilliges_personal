import { HelpingHand, Job } from '@/interfaces/types';
import {defaultClient} from "@/clients/default";

const jobs = [
    {
        "title": "Reinigung von Betten",
        "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum enim ut nibh lacinia, in faucibus enim sagittis. Nulla eu pellentesque odio, vitae hendrerit neque. Aenean tincidunt pretium justo sed placerat. Maecenas enim est, efficitur sed commodo eget, faucibus eget nulla. Fusce ultricies finibus nibh, et feugiat risus. Cras eu augue ac dolor imperdiet gravida. Morbi eleifend tortor at elit auctor accumsan. Donec volutpat urna a nunc egestas feugiat. Nullam tincidunt vehicula rhoncus. Sed at nunc et nisl tempor tincidunt. Sed ac ornare purus.",
        "skillSet": [
            "cleaning",
            "materialCare"
        ],
        "location": {
            "name": "Eduardus Krankenhaus",
            "street": "Custodisstraße 3-17",
            "zipCode": "50679",
            "city": "Köln",
            "country": "Deutschland",
            "lat": 50.932535,
            "lng": 6.978679,
            "phone": "123456",
            "fax": "123456",
            "email": "a@b.de"
        }
    },
    {
        "title": "Reinigung von Betten",
        "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum enim ut nibh lacinia, in faucibus enim sagittis. Nulla eu pellentesque odio, vitae hendrerit neque. Aenean tincidunt pretium justo sed placerat. Maecenas enim est, efficitur sed commodo eget, faucibus eget nulla. Fusce ultricies finibus nibh, et feugiat risus. Cras eu augue ac dolor imperdiet gravida. Morbi eleifend tortor at elit auctor accumsan. Donec volutpat urna a nunc egestas feugiat. Nullam tincidunt vehicula rhoncus. Sed at nunc et nisl tempor tincidunt. Sed ac ornare purus.",
        "skillSet": [
            "cleaning",
            "materialCare"
        ],
        "location": {
            "name": "Eduardus Krankenhaus",
            "street": "Custodisstraße 3-17",
            "zipCode": "50679",
            "city": "Köln",
            "country": "Deutschland",
            "lat": 50.932535,
            "lng": 6.978679,
            "phone": "123456",
            "fax": "123456",
            "email": "a@b.de"
        }
    },
    {
        "title": "Reinigung von Betten",
        "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum enim ut nibh lacinia, in faucibus enim sagittis. Nulla eu pellentesque odio, vitae hendrerit neque. Aenean tincidunt pretium justo sed placerat. Maecenas enim est, efficitur sed commodo eget, faucibus eget nulla. Fusce ultricies finibus nibh, et feugiat risus. Cras eu augue ac dolor imperdiet gravida. Morbi eleifend tortor at elit auctor accumsan. Donec volutpat urna a nunc egestas feugiat. Nullam tincidunt vehicula rhoncus. Sed at nunc et nisl tempor tincidunt. Sed ac ornare purus.",
        "skillSet": [
            "cleaning",
            "materialCare"
        ],
        "location": {
            "name": "Eduardus Krankenhaus",
            "street": "Custodisstraße 3-17",
            "zipCode": "50679",
            "city": "Köln",
            "country": "Deutschland",
            "lat": 50.932535,
            "lng": 6.978679,
            "phone": "123456",
            "fax": "123456",
            "email": "a@b.de"
        }
    },
    {
        "title": "Reinigung von Betten",
        "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum enim ut nibh lacinia, in faucibus enim sagittis. Nulla eu pellentesque odio, vitae hendrerit neque. Aenean tincidunt pretium justo sed placerat. Maecenas enim est, efficitur sed commodo eget, faucibus eget nulla. Fusce ultricies finibus nibh, et feugiat risus. Cras eu augue ac dolor imperdiet gravida. Morbi eleifend tortor at elit auctor accumsan. Donec volutpat urna a nunc egestas feugiat. Nullam tincidunt vehicula rhoncus. Sed at nunc et nisl tempor tincidunt. Sed ac ornare purus.",
        "skillSet": [
            "cleaning",
            "materialCare"
        ],
        "location": {
            "name": "Eduardus Krankenhaus",
            "street": "Custodisstraße 3-17",
            "zipCode": "50679",
            "city": "Köln",
            "country": "Deutschland",
            "lat": 50.932535,
            "lng": 6.978679,
            "phone": "123456",
            "fax": "123456",
            "email": "a@b.de"
        }
    },
    {
        "title": "Reinigung von Betten",
        "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum enim ut nibh lacinia, in faucibus enim sagittis. Nulla eu pellentesque odio, vitae hendrerit neque. Aenean tincidunt pretium justo sed placerat. Maecenas enim est, efficitur sed commodo eget, faucibus eget nulla. Fusce ultricies finibus nibh, et feugiat risus. Cras eu augue ac dolor imperdiet gravida. Morbi eleifend tortor at elit auctor accumsan. Donec volutpat urna a nunc egestas feugiat. Nullam tincidunt vehicula rhoncus. Sed at nunc et nisl tempor tincidunt. Sed ac ornare purus.",
        "skillSet": [
            "cleaning",
            "materialCare"
        ],
        "location": {
            "name": "Eduardus Krankenhaus",
            "street": "Custodisstraße 3-17",
            "zipCode": "50679",
            "city": "Köln",
            "country": "Deutschland",
            "lat": 50.932535,
            "lng": 6.978679,
            "phone": "123456",
            "fax": "123456",
            "email": "a@b.de"
        }
    },
    {
        "title": "Reinigung von Betten",
        "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum enim ut nibh lacinia, in faucibus enim sagittis. Nulla eu pellentesque odio, vitae hendrerit neque. Aenean tincidunt pretium justo sed placerat. Maecenas enim est, efficitur sed commodo eget, faucibus eget nulla. Fusce ultricies finibus nibh, et feugiat risus. Cras eu augue ac dolor imperdiet gravida. Morbi eleifend tortor at elit auctor accumsan. Donec volutpat urna a nunc egestas feugiat. Nullam tincidunt vehicula rhoncus. Sed at nunc et nisl tempor tincidunt. Sed ac ornare purus.",
        "skillSet": [
            "cleaning",
            "materialCare"
        ],
        "location": {
            "name": "Eduardus Krankenhaus",
            "street": "Custodisstraße 3-17",
            "zipCode": "50679",
            "city": "Köln",
            "country": "Deutschland",
            "lat": 50.932535,
            "lng": 6.978679,
            "phone": "123456",
            "fax": "123456",
            "email": "a@b.de"
        }
    },
    {
        "title": "Reinigung von Betten",
        "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum enim ut nibh lacinia, in faucibus enim sagittis. Nulla eu pellentesque odio, vitae hendrerit neque. Aenean tincidunt pretium justo sed placerat. Maecenas enim est, efficitur sed commodo eget, faucibus eget nulla. Fusce ultricies finibus nibh, et feugiat risus. Cras eu augue ac dolor imperdiet gravida. Morbi eleifend tortor at elit auctor accumsan. Donec volutpat urna a nunc egestas feugiat. Nullam tincidunt vehicula rhoncus. Sed at nunc et nisl tempor tincidunt. Sed ac ornare purus.",
        "skillSet": [
            "cleaning",
            "materialCare"
        ],
        "location": {
            "name": "Eduardus Krankenhaus",
            "street": "Custodisstraße 3-17",
            "zipCode": "50679",
            "city": "Köln",
            "country": "Deutschland",
            "lat": 50.932535,
            "lng": 6.978679,
            "phone": "123456",
            "fax": "123456",
            "email": "a@b.de"
        }
    },
];

export const getAvailableJobs = async (zipCode: string, distance: number) => Promise.resolve(jobs);

export const registerHelpingHand = async (
    person: HelpingHand,
): Promise<any> => {
    // some validation?
    console.log(person);
    return defaultClient.post('/register', person);
};