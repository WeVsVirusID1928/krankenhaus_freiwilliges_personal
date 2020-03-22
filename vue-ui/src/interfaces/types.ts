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

export interface Location {
    name: string;
    street: string;
    zipCode: string;
    city: string;
    country: string;
    lat: number;
    lng: number;
    phone: string;
    fax: string;
    email: string;
}

export interface Job {
    title: string;
    description: string;
    skillSet: string[];
    location: Location;
}