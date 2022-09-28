// Singleto basta con declararlo como object en lugar de class
// los tipos objeto pueden extender de otro tipo
object NoMoviesList

fun main () {
    val myFavoriteQuickAndAngryMovies = NoMoviesList
    val yourFavoriteQuickAndAngryMovies = NoMoviesList

    // ambos son el mismo objeto en memoria (secomprueba con el operador ===)
    print (myFavoriteQuickAndAngryMovies === yourFavoriteQuickAndAngryMovies)
}