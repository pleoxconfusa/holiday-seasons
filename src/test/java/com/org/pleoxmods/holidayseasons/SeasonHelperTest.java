package com.org.pleoxmods.holidayseasons;
import com.google.common.annotations.VisibleForTesting;
import com.org.pleoxmods.holidayseasons.block.SeasonalBlock;
import com.org.pleoxmods.holidayseasons.seasons.SeasonHelper;
import com.sun.org.slf4j.internal.LoggerFactory;
import net.minecraft.block.Block;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit;

import java.util.List;

public class SeasonHelperTest {
    LOGGER logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void testSeasonHelper(){
        SeasonHelper helper = new SeasonHelper();
        List<SeasonalBlock> blocks = helper.getSeasonalBlocks();
        assert.assertTrue(blocks != null && ! blocks.isEmpty());
        logger.info("[testSeasonHelper] Seasonal Blocks for {}: {}", helper.getSeason(), blocks);
    }

}
