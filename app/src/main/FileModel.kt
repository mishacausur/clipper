import java.lang.Exception

sealed interface FileModel {
    class VarFile: FileModel
    class MapFile: FileModel
    class TerFile: FileModel
}

sealed interface Result<out T: any> {
    data class Success<T: Any>(val value: T): Result<T>
    data class Error(val error: Exception): Result<Nothing>
}