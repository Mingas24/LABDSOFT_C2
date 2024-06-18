import { Pipe, PipeTransform } from "@angular/core";

@Pipe({
    name: 'objectValue'
})

export class ObjectValuePipe implements PipeTransform {
    transform(row: any, value: String): string {
        return eval('row.' + value);
        
    }
}