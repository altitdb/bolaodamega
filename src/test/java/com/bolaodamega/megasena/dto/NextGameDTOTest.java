package com.bolaodamega.megasena.dto;

import org.junit.Assert;
import org.junit.Test;

import com.bolaodamega.megasena.dto.NextGameDTO;

public class NextGameDTOTest {

	@Test
	public void shouldValidateMinimumAmount() {
		NextGameDTO dto = new NextGameDTO();
		Assert.assertSame(1, dto.getAmount());
	}

}
