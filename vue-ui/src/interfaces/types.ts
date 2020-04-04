export interface ChipValue {
    key: string;
    label: string;
}

export interface HelpingHand {
    firstName: string;
    lastName: string;
    zipCode: string;
    maxDistance: number;
    skillSet: string[];
    additionalSkills: string[];
}

export interface JobLocation {
    name: string;
    street: string;
    zipCode: string;
    city: string;
    country: string;
    latitude: number;
    longitude: number;
    phone: string;
    fax: string;
    email: string;
    distance: string;
}

export interface Job {
    title: string;
    description: string;
    skillSet: string[];
    location: JobLocation;
}