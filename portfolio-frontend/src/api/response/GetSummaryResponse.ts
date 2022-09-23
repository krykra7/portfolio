import {ProjectResponse} from "./ProjectResponse";
import {SkillGroupResponse} from "./SkillGroupResponse";
import {ServiceGroupResponse} from "./ServiceGroupResponse";

export type GetSummaryResponse = {
    about: string;
    experienceSummary: string;
    clientsSummary: string;
    projectsSummary: string;
    projects: ProjectResponse[];
    skillGroups: SkillGroupResponse[];
    serviceGroups: ServiceGroupResponse[];
}
