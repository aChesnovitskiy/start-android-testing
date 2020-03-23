package ru.startandroid.testing.utils


import android.content.Context
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.CoreMatchers.`is` as Is
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import ru.startandroid.testing.R

class UriValidatorTest {
    companion object {
        const val NOTHING = "Nothing"
        const val URL = "URL"
        const val FILE = "File"
    }

    private val mockContext: Context = Mockito.mock(Context::class.java)
    private val uriValidator = UriValidator(mockContext)

    @Before
    fun setUp() {
        Mockito.`when`(mockContext.getString(R.string.nothing)).thenReturn(NOTHING)
        Mockito.`when`(mockContext.getString(R.string.url)).thenReturn(URL)
        Mockito.`when`(mockContext.getString(R.string.file)).thenReturn(FILE)
    }

    @Test
    fun validate() {
        assertThat(uriValidator.validate("http://google.com"), Is(URL))
        assertThat(uriValidator.validate("file://sdcard/DCIM/img001.jpg"), Is(FILE))
        assertThat(uriValidator.validate("bla-bla-bla"), Is(NOTHING))
    }
}