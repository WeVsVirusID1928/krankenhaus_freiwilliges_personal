import { HelpingHand, JobLocation } from '@/interfaces/types';
import { defaultClient } from '@/clients/default';


const jobLocations: JobLocation[] = [
    {
        name: 'Evangelische Elisabeth Klinik',
        street: 'Lützowstraße 26',
        zipCode: '10785',
        city: 'Berlin',
        country: 'Deutschland',
        latitude: 52.5031338,
        longitude: 13.3626897,
        phone: '123456',
        fax: '123456',
        email: 'a@b.de',
        distance: '1,3 km'
    },
    {
        name: 'Charité – Universitätsmedizin Berlin',
        street: 'Charitéplatitudez 1',
        zipCode: '10117',
        city: 'Berlin',
        country: 'Deutschland',
        latitude: 52.5250854,
        longitude: 13.3755031,
        phone: '123456',
        fax: '123456',
        email: 'a@b.de',
        distance: '2,2 km'
    },
    {
        name: 'Alexianer St. Hedwig Krankenhaus',
        street: 'Große Hamburger Str. 5-11',
        zipCode: '10115',
        city: 'Berlin',
        country: 'Deutschland',
        latitude: 52.5264531,
        longitude: 13.3956137,
        phone: '123456',
        fax: '123456',
        email: 'a@b.de',
        distance: '3,0 km'
    },
    {
        name: 'Bundeswehrkrankenhaus Berlin',
        street: 'Scharnhorststraße 13',
        zipCode: '10115',
        city: 'Berlin',
        country: 'Deutschland',
        latitude: 52.5349771,
        longitude: 13.3676693,
        phone: '123456',
        fax: '123456',
        email: 'a@b.de',
        distance: '3,6 km'
    },
    {
        name: 'Unfallkrankenhaus Berlin',
        street: 'Warener Str. 7',
        zipCode: '12683',
        city: 'Berlin',
        country: 'Deutschland',
        latitude: 52.5192015,
        longitude: 13.5653362,
        phone: '123456',
        fax: '123456',
        email: 'a@b.de',
        distance: '14,7 km'
    }
];

const jobs = [
    {
        title: 'Reinigung von Betten',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum enim ut nibh lacinia, in faucibus enim sagittis. Nulla eu pellentesque odio, vitae hendrerit neque. Aenean tincidunt pretium justo sed placerat. Maecenas enim est, efficitur sed commodo eget, faucibus eget nulla. Fusce ultricies finibus nibh, et feugiat risus. Cras eu augue ac dolor imperdiet gravida. Morbi eleifend tortor at elit auctor accumsan. Donec volutpat urna a nunc egestas feugiat. Nullam tincidunt vehicula rhoncus. Sed at nunc et nisl tempor tincidunt. Sed ac ornare purus.',
        skillSet: [
            'desinfection',
            'logistics'
        ],
        location: jobLocations[0]
    },
    {
        title: 'Reinigung von Betten',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum enim ut nibh lacinia, in faucibus enim sagittis. Nulla eu pellentesque odio, vitae hendrerit neque. Aenean tincidunt pretium justo sed placerat. Maecenas enim est, efficitur sed commodo eget, faucibus eget nulla. Fusce ultricies finibus nibh, et feugiat risus. Cras eu augue ac dolor imperdiet gravida. Morbi eleifend tortor at elit auctor accumsan. Donec volutpat urna a nunc egestas feugiat. Nullam tincidunt vehicula rhoncus. Sed at nunc et nisl tempor tincidunt. Sed ac ornare purus.',
        skillSet: [
            'desinfection',
            'logistics'
        ],
        location: jobLocations[1]
    },
    {
        title: 'Reinigung von Betten',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum enim ut nibh lacinia, in faucibus enim sagittis. Nulla eu pellentesque odio, vitae hendrerit neque. Aenean tincidunt pretium justo sed placerat. Maecenas enim est, efficitur sed commodo eget, faucibus eget nulla. Fusce ultricies finibus nibh, et feugiat risus. Cras eu augue ac dolor imperdiet gravida. Morbi eleifend tortor at elit auctor accumsan. Donec volutpat urna a nunc egestas feugiat. Nullam tincidunt vehicula rhoncus. Sed at nunc et nisl tempor tincidunt. Sed ac ornare purus.',
        skillSet: [
            'desinfection',
            'logistics'
        ],
        location: jobLocations[2]
    },
    {
        title: 'Reinigung von Betten',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum enim ut nibh lacinia, in faucibus enim sagittis. Nulla eu pellentesque odio, vitae hendrerit neque. Aenean tincidunt pretium justo sed placerat. Maecenas enim est, efficitur sed commodo eget, faucibus eget nulla. Fusce ultricies finibus nibh, et feugiat risus. Cras eu augue ac dolor imperdiet gravida. Morbi eleifend tortor at elit auctor accumsan. Donec volutpat urna a nunc egestas feugiat. Nullam tincidunt vehicula rhoncus. Sed at nunc et nisl tempor tincidunt. Sed ac ornare purus.',
        skillSet: [
            'desinfection',
            'logistics'
        ],
        location: jobLocations[3]
    },
    {
        title: 'Reinigung von Betten',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum enim ut nibh lacinia, in faucibus enim sagittis. Nulla eu pellentesque odio, vitae hendrerit neque. Aenean tincidunt pretium justo sed placerat. Maecenas enim est, efficitur sed commodo eget, faucibus eget nulla. Fusce ultricies finibus nibh, et feugiat risus. Cras eu augue ac dolor imperdiet gravida. Morbi eleifend tortor at elit auctor accumsan. Donec volutpat urna a nunc egestas feugiat. Nullam tincidunt vehicula rhoncus. Sed at nunc et nisl tempor tincidunt. Sed ac ornare purus.',
        skillSet: [
            'desinfection',
            'logistics'
        ],
        location: jobLocations[2]
    },
    {
        title: 'Reinigung von Betten',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum enim ut nibh lacinia, in faucibus enim sagittis. Nulla eu pellentesque odio, vitae hendrerit neque. Aenean tincidunt pretium justo sed placerat. Maecenas enim est, efficitur sed commodo eget, faucibus eget nulla. Fusce ultricies finibus nibh, et feugiat risus. Cras eu augue ac dolor imperdiet gravida. Morbi eleifend tortor at elit auctor accumsan. Donec volutpat urna a nunc egestas feugiat. Nullam tincidunt vehicula rhoncus. Sed at nunc et nisl tempor tincidunt. Sed ac ornare purus.',
        skillSet: [
            'desinfection',
            'logistics'
        ],
        location: jobLocations[1]
    },
    {
        title: 'Reinigung von Betten',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum enim ut nibh lacinia, in faucibus enim sagittis. Nulla eu pellentesque odio, vitae hendrerit neque. Aenean tincidunt pretium justo sed placerat. Maecenas enim est, efficitur sed commodo eget, faucibus eget nulla. Fusce ultricies finibus nibh, et feugiat risus. Cras eu augue ac dolor imperdiet gravida. Morbi eleifend tortor at elit auctor accumsan. Donec volutpat urna a nunc egestas feugiat. Nullam tincidunt vehicula rhoncus. Sed at nunc et nisl tempor tincidunt. Sed ac ornare purus.',
        skillSet: [
            'desinfection',
            'logistics'
        ],
        location: jobLocations[4]
    },
];

export const getJobLocations = async (zipCode: string, distance: number) => Promise.resolve(jobLocations);

export const getAvailableJobs = async (zipCode: string, distance: number) => Promise.resolve(jobs);

export const registerHelpingHand = async (
    person: HelpingHand,
): Promise<any> => {
    // some validation?
    return defaultClient.post('/register', person);
};

export const getAllLocations = async (): Promise<JobLocation> => {
    return defaultClient.get('/api/hospital/all')
    .then(response => response.data)
    .catch(error => console.log("trouble fetching hospitals from api", error));
};