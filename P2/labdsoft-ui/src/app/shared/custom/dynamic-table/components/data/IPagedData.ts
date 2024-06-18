export interface IPagedData<T>{
    content: T[];
    number: number;
    size: number;
    totalElements: number;
    totalPages: number;
}